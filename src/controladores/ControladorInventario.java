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
import vistas.VentanaInventario;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class ControladorInventario {
    private final AdministradorInventario administradorInventario;
    
    public ControladorInventario() {
        administradorInventario = AdministradorInventario.obtenerUnicoAdministradorInventario();                
    }
    
    public void mandarModificacionesAlInventario(InventarioProducto producto){
        administradorInventario.actualizarInventario(producto);
    }
    
    public void actualizarVentanaInventario(){
        VentanaInventario.obtenerUnicaVentanaInventario().mostrarInventarioProductos(
                administradorInventario.obtenerInventarioProductos());
    }
    
    public ArrayList<InventarioProducto> obtenerInventarioProductos(){
        return administradorInventario.obtenerInventarioProductos();
    }
}