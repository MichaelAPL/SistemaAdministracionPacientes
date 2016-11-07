/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Aplicacion;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class AplicacionDAO {
    private ConectorBD conectorBD;
    
    public AplicacionDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public void crearAplicacion(Aplicacion aplicacion) throws SQLException{
        conectorBD.conectar();
        
        String campos = "Realizada, Fecha, Num_Aplicacion, Tratamiento_ID";
        String consulta = "INSERT INTO Aplicacion ("+campos+") VALUES (?,?,?,?)";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        declaracion.setBoolean(1, aplicacion.isRealizada());
        
        java.sql.Date fechaAplicacion = new java.sql.Date(aplicacion.getFecha().getTime());
        declaracion.setDate(2, fechaAplicacion);
        declaracion.setInt(3, aplicacion.getNumAplicacion());
        declaracion.setInt(4, aplicacion.getTratamiento_id());
        
        conectorBD.desconectar();
    }
}
