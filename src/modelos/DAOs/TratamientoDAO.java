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
    private ConectorBD conectorBD; 
    private AplicacionDAO aplicacionDAO;
    
    
    public TratamientoDAO(){
        this.conectorBD = new ConectorBD();
        this.aplicacionDAO = new AplicacionDAO();
    }
    
    public void crearTratamiento(Tratamiento tratamiento) throws SQLException{
        conectorBD.conectar();
        
        String campos = "ID_Tratamiento, DosisEDTA, Activo, Paciente_ID";
        String consulta = "INSERT INTO Tratamiento ("+campos+")"+" VALUES (?,?,?,?)";
        
        PreparedStatement declaracionTratamiento = conectorBD.consulta(consulta);
        
        declaracionTratamiento.setInt(2, tratamiento.getDosisEDTA());
        declaracionTratamiento.setBoolean(3, tratamiento.isActivo());
        declaracionTratamiento.setInt(4, tratamiento.getPaciente_id());
        
        declaracionTratamiento.execute();
        
        conectorBD.desconectar();
        
        aplicacionDAO.crearAplicacion(tratamiento.getSiguienteAplicacion());               
    }
}
