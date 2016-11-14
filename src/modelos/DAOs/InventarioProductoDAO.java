/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.InventarioProducto;
import modelos.database.ConectorBD;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class InventarioProductoDAO {
    private ConectorBD conectorBD;

    public InventarioProductoDAO() {
        this.conectorBD = new ConectorBD();
    }  
    
    public void crearInventarioProducto(InventarioProducto inventarioProducto) throws SQLException{
        conectorBD.conectar();
        
        String campos = "Producto_ID, Nombre, Existencias";
        String consulta= "INSERT INTO Inventario ("+campos+") VALUES (?,?,?)";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        declaracion.setString(2, inventarioProducto.getNombre());
        declaracion.setInt(3, inventarioProducto.getExistencias());
        declaracion.execute();
        
        conectorBD.desconectar();
    }

}
