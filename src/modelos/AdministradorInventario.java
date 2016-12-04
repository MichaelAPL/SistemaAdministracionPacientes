/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.DAOs.InventarioMedicamentosDAO;
import modelos.DAOs.InventarioUtensiliosDAO;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class AdministradorInventario {
    private InventarioUtensiliosDAO inventarioUtensiliosDAO;
    private InventarioMedicamentosDAO inventarioMedicamentosDAO;
    private static AdministradorInventario administradorInventario;
    
    private AdministradorInventario(){
        inventarioUtensiliosDAO = new InventarioUtensiliosDAO();
        inventarioMedicamentosDAO = new InventarioMedicamentosDAO();
    }
    
    public static AdministradorInventario obtenerUnicoAdministradorInventario(){
        if(administradorInventario == null){
            administradorInventario = new AdministradorInventario();
        }
        return administradorInventario;
    }
    
    public void actualizarInventario(Insumo insumo){        
        try {
            if(insumo instanceof InventarioMedicamentos){
                inventarioMedicamentosDAO.actualizar((InventarioMedicamentos) insumo);
            }else{
                System.out.println("Guardando en la bd utensilio");
                inventarioUtensiliosDAO.actualizar((InventarioUtensilios)insumo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Insumo> obtenerInventarioInsumos(){
        ArrayList<Insumo> inventarioInsumo = null;
        try {
            inventarioInsumo = inventarioMedicamentosDAO.recuperarTodoInventarioMedicamentos();
            inventarioInsumo.addAll(inventarioUtensiliosDAO.recuperarTodoInventarioUtensilios());
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inventarioInsumo;        
    }
}
