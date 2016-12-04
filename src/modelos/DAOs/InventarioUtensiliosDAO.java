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
import modelos.Insumo;
import modelos.InventarioUtensilios;
import modelos.database.ConectorBD;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class InventarioUtensiliosDAO {
    private ConectorBD conectorBD;
    
    public InventarioUtensiliosDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public ArrayList<Insumo> recuperarTodoInventarioUtensilios() throws SQLException{
        conectorBD.conectar();
        
        String consulta = "select * from InventarioUtensilios";
        
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracionDeRecuperacion.executeQuery();
        
        //**********************
        ArrayList<Insumo> inventarioUtensilios = new ArrayList();
        
        while(resultado.next()){
            InventarioUtensilios utensilio = new InventarioUtensilios(resultado.getString("Nombre_Utensilio"), 
                            resultado.getInt("Existencias"), resultado.getDouble("Costo_Unitario"));
            
            inventarioUtensilios.add(utensilio);
        }
        
        this.conectorBD.desconectar();
        //**********************
        return inventarioUtensilios;
    }
    
    public void actualizar(InventarioUtensilios utensilio) throws SQLException{
        conectorBD.conectar();
        
        String consulta = "UPDATE InventarioUtensilios SET Existencias = ?,"
                + "Costo_Unitario = ?"
                + "where Nombre_Utensilio = ?";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        declaracion.setInt(1, utensilio.getExistencias());
        declaracion.setDouble(2, utensilio.getCostoUnitario());
        declaracion.setString(3, utensilio.getNombre());
        
        declaracion.execute();
        
        this.conectorBD.desconectar();
    }
}
