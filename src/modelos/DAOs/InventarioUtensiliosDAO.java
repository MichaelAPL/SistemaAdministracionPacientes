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
    private final int INDICE_Nombre_Utensilio = 1;
    private final int INDICE_Existencias = 2;
    private final int INDICE_Costo_Unitario = 3;
    
    public InventarioUtensiliosDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public void actualizar(InventarioUtensilios utensilio) throws SQLException{
        conectorBD.conectar();
        int INDICE_Clausula = 3;
        
        String consulta = "UPDATE InventarioUtensilios SET Existencias = ?,"
                + "Costo_Unitario = ?"
                + "where Nombre_Utensilio = ?";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        declaracion.setInt(this.INDICE_Existencias-1, utensilio.getExistencias());
        declaracion.setDouble(this.INDICE_Costo_Unitario-1, utensilio.getCostoUnitario());
        declaracion.setString(INDICE_Clausula, utensilio.getNombre());
        
        declaracion.execute();
        
        this.conectorBD.desconectar();
    }
    
    public ArrayList<Insumo> recuperarTodoInventarioUtensilios() throws SQLException{
        conectorBD.conectar();
        
        String consulta = "select * from InventarioUtensilios";
        
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracionDeRecuperacion.executeQuery();
        
        //**********************
        ArrayList<Insumo> inventarioUtensilios = new ArrayList();
        
        while(resultado.next()){
            InventarioUtensilios utensilio = new InventarioUtensilios(resultado.getString(this.INDICE_Nombre_Utensilio), 
                            resultado.getInt(this.INDICE_Existencias), 
                            resultado.getDouble(this.INDICE_Costo_Unitario));
            
            inventarioUtensilios.add(utensilio);
        }
        
        this.conectorBD.desconectar();
        //**********************
        return inventarioUtensilios;
    }
}
