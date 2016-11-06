/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Cita;
import modelos.database.ConectorBD;
import modelos.enums.DatosCita;

/**
 *
 * @author miguelangel
 */
public class CitaDAO {
    ConectorBD conectorBD;
    
    public CitaDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public void crearCita( Cita cita ) throws SQLException{
        conectorBD.conectar();
        
        String campos = "FechaDeRealizacion, FechaProgramada, NumeroDeCita, Realizada, ClvPaciente";
        String consulta = "INSERT INTO Citas ("+campos+")"+" VALUES (?,?,?,?,?)";
        
        PreparedStatement declaracionCita = conectorBD.consulta(consulta);
        
        java.sql.Date fechaDeRealizacion = new java.sql.Date( cita.getFechaDeRealizacion().getTime() );
        declaracionCita.setDate( DatosCita.FECHA_DE_REALIZACION.getDato(), fechaDeRealizacion );
        
        java.sql.Date fechaProgramada = new java.sql.Date( cita.getFechaProgramada().getTime() );
        declaracionCita.setDate( DatosCita.FECHA_PROGRAMADA.getDato(), fechaProgramada );
        
        declaracionCita.setInt( DatosCita.NUMERO_DE_CITA.getDato(), cita.getNumeroDeCita() );
        declaracionCita.setBoolean( DatosCita.REALIZADA.getDato(), cita.isRealizada() );
        declaracionCita.setString( DatosCita.CLV_PACIENTE.getDato(), cita.getClavePaciente() );
        
        declaracionCita.execute();
        conectorBD.desconectar();
    }
}
