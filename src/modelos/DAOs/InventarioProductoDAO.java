/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ArrayList<InventarioProducto> recuperarTodos() throws SQLException{
        this.conectorBD.conectar();
        
        String consulta = "select * from Inventario";
        
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracionDeRecuperacion.executeQuery();
        
        //**********************
        ArrayList<InventarioProducto> inventarioProductos = new ArrayList();
        
        while(resultado.next()){
            InventarioProducto producto = new InventarioProducto(resultado.getString("Nombre"), 
                            resultado.getInt("Existencias"));
            
            inventarioProductos.add(producto);
        }
        
        this.conectorBD.desconectar();
        //**********************
        return inventarioProductos;
    }
    
    public void actualizar(InventarioProducto inventarioProducto) throws SQLException{
        this.conectorBD.conectar();
        
        String consulta = "UPDATE Inventario SET Nombre = ?, Existencias = ?"
                + "where Producto_ID = ?";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        declaracion.setString(1, inventarioProducto.getNombre());
        declaracion.setInt(2, inventarioProducto.getExistencias());
        declaracion.setInt(3, inventarioProducto.getId());
        
        declaracion.execute();
        
        this.conectorBD.desconectar();        
    }

}
