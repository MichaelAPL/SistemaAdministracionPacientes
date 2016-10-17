/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Tratamiento;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class TratamientoDAO {
    ConectorBD conectorBD; 
    
    public TratamientoDAO(){
        conectorBD = new ConectorBD();
    }
    
    public void crearTratamiento(Tratamiento tratamiento, String clvPaciente) throws SQLException{
        conectorBD.conectar();
        
        String campos = "DosisEDTA, NumeroDeSuerosAplicados, Suero, ClvPaciente";
        String consulta = "INSER INTO Tratamiento ("+campos+")"+" VALUES (?,?,?)";
        
        PreparedStatement declaracionTratamiento = conectorBD.consulta(consulta);
        
        declaracionTratamiento.setInt(1, tratamiento.getDosisEDTA());
        declaracionTratamiento.setString(2, tratamiento.sueroAaplicar().toString());
        declaracionTratamiento.setString(3, clvPaciente);
        
        declaracionTratamiento.execute();
        conectorBD.desconectar();
    }
}
