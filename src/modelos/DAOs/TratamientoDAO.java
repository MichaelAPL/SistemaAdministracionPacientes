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
    
    public void crearTratamiento(Tratamiento tratamiento) throws SQLException{
        conectorBD.conectar();
        
        String campos = "DosisEDTA, NumeroDeSuerosAplicados, ClvPaciente";
        String consulta = "INSERT INTO Tratamiento ("+campos+")"+" VALUES (?,?,?)";
        
        PreparedStatement declaracionTratamiento = conectorBD.consulta(consulta);
        
        declaracionTratamiento.setInt(1, tratamiento.getDosisEDTA());
        declaracionTratamiento.setInt(2, tratamiento.getNumeroSuerosAplicados());
        declaracionTratamiento.setString(3, tratamiento.getClavePaciente());
        
        declaracionTratamiento.execute();
        conectorBD.desconectar();
    }
}
