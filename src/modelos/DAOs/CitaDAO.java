/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Cita;
import modelos.Paciente;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class CitaDAO {
    ConectorBD conectorBD;
    
    public CitaDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public void crearCita(Cita cita) throws SQLException{
        conectorBD.conectar();
        
        String campos = "FechaDeRealizacion, FechaProgramada, NumeroDeCita, Relizada, ClvPaciente";
        String consulta = "INSER INTO Tratamiento ("+campos+")"+" VALUES (?,?,?,?,?)";
        
        PreparedStatement declaracionCita = conectorBD.consulta(consulta);
        
        java.sql.Date fechaAux = new java.sql.Date(cita.getFechaDeRealizacion().getTime());
        declaracionCita.setDate(1, fechaAux);
        
        fechaAux = new java.sql.Date(cita.getFechaProgramada().getTime());
        declaracionCita.setDate(2, fechaAux);
        
        declaracionCita.setInt(3, cita.getNumeroDeCita());
        declaracionCita.setBoolean(4, cita.isRealizada());
        declaracionCita.setString(5, cita.getClavePaciente());
        
        declaracionCita.execute();
        conectorBD.desconectar();
    }
}
