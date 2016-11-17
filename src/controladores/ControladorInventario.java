/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.AdministradorInventario;
import modelos.DAOs.InventarioProductoDAO;
import modelos.InventarioProducto;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class ControladorInventario {
    InventarioProductoDAO inventarioProductoDAO = new InventarioProductoDAO();
    private final AdministradorInventario administradorInventario;
    
    public ControladorInventario() {
        administradorInventario = AdministradorInventario.obtenerUnicoAdministradorInventario();                
    }
    
    public void agregarInsumosInventario(InventarioProducto producto){
        administradorInventario.actualizarInventario(producto);
    }
    
    public ArrayList<InventarioProducto> obtenerInventarioProductos(){
        ArrayList<InventarioProducto> inventarioProducto = null;
        try {
            inventarioProducto = inventarioProductoDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inventarioProducto;
    }
}