/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        
        ResultSet generatedKeys = declaracionTratamiento.getGeneratedKeys();
        if (generatedKeys.next()) {
            int tratamiento_id = generatedKeys.getInt(1);
            tratamiento.getSiguienteAplicacion().setTratamiento_id(tratamiento_id);
        }
        
        conectorBD.desconectar();
        
        aplicacionDAO.crearAplicacion(tratamiento.getSiguienteAplicacion());               
    }
    
    public Tratamiento getTratamiento(int paciente_id) throws SQLException{
        conectorBD.conectar();
        String consulta = "select * from Tratamiento where Paciente_ID = ? and "
                + "Activo = ?";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        declaracion.setInt(1, paciente_id);
        declaracion.setBoolean(2, true);
        
        ResultSet resultado = declaracion.executeQuery();
        
        Tratamiento tratamiento = null;
        while(resultado.next()){
            tratamiento = new Tratamiento(resultado.getInt("DosisEDTA"));
            tratamiento.setId(resultado.getInt("ID_Tratamiento"));
            tratamiento.setActivo(resultado.getBoolean("Activo"));
            tratamiento.setPaciente_id(resultado.getInt("Paciente_ID"));            
            tratamiento.setSiguienteAplicacion(aplicacionDAO.getSiguienteAplicacion(tratamiento.getId()));                    
        }
        
        conectorBD.desconectar();
        
        return tratamiento;
    }
    
    public void actualizar(Tratamiento tratamiento) throws SQLException{
        conectorBD.conectar();
        String consulta = "UPDATE Tratamiento SET DosisEDTA = ?, Activo = ? "
                + "where ID_Tratamiento = ?";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        declaracion.setInt(1, tratamiento.getDosisEDTA());
        declaracion.setBoolean(2, tratamiento.isActivo());
        declaracion.setInt(3, tratamiento.getId());
        
        declaracion.execute();        
        
        conectorBD.desconectar();
        
        if (tratamiento.getUltimaAplicacion()!=null) {
            aplicacionDAO.actualizar(tratamiento.getUltimaAplicacion());
        }
        aplicacionDAO.crearAplicacion(tratamiento.getSiguienteAplicacion());        
    }
}
