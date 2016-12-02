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
import modelos.DAOs.InventarioProductoDAO;
import vistas.VentanaInventario;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class AdministradorInventario {
    private InventarioProductoDAO inventarioDAO;
    private static AdministradorInventario administradorInventario;
    
    private AdministradorInventario(){
        inventarioDAO = new InventarioProductoDAO();
    }
    
    public static AdministradorInventario obtenerUnicoAdministradorInventario(){
        if(administradorInventario == null){
            administradorInventario = new AdministradorInventario();
        }
        return administradorInventario;
    }
    
    public void actualizarInventario(InventarioProducto producto){
        try {
            inventarioDAO.actualizar(producto);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<InventarioProducto> obtenerInventarioProductos(){
        ArrayList<InventarioProducto> inventarioProducto = null;
        try {
            inventarioProducto = inventarioDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inventarioProducto;
    }
}
