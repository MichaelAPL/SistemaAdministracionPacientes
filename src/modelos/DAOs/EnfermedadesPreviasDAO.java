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
import modelos.Paciente;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class EnfermedadesPreviasDAO {
    private ConectorBD conectorBD;
    
    public EnfermedadesPreviasDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public void actualizar(Paciente paciente) throws SQLException{
        //indices campos
        int INDICE_PACIENTE_ID = 1;
        
        conectorBD.conectar();
        
        String consultaEliminacion = "DELETE FROM EnfermedadesPrevias "
                + "where Paciente_ID = ?";
        
        PreparedStatement declaracionEliminacion = conectorBD.consulta(consultaEliminacion);
        declaracionEliminacion.setInt(INDICE_PACIENTE_ID, paciente.getId());
        
        declaracionEliminacion.execute();
        
        conectorBD.desconectar();
        
        crearEnfermedadesPrevias(paciente);
    }
        
    public void crearEnfermedadesPrevias(Paciente paciente) throws SQLException{
        //indices campos
        int INDICE_PACIENTE_ID = 1;
        int INDICE_NUM_ENFERM = 2;
        int INDICE_NOMBRE_ENFER = 3;
        
        conectorBD.conectar();
        
        String camposEnfermedades = "Paciente_ID, NumEnfer, NombreEnfer";
        String consulta = "INSERT INTO EnfermedadesPrevias (" + camposEnfermedades + ")" +
                " VALUES (?, ?, ?)";
        
        for (int iEnfermedad = 0; iEnfermedad < paciente.getEnfermedadesPrevias().size(); iEnfermedad++) {
            PreparedStatement declaracionEnfermedades = conectorBD.consulta(consulta);
            declaracionEnfermedades.setInt(INDICE_PACIENTE_ID, paciente.getId());
            declaracionEnfermedades.setInt(INDICE_NUM_ENFERM, iEnfermedad);
            declaracionEnfermedades.setString(INDICE_NOMBRE_ENFER, paciente.
                    getEnfermedadesPrevias().get(iEnfermedad));
            declaracionEnfermedades.execute();
        }
                        
        conectorBD.desconectar();
    }
    
    public ArrayList<String> getEnfermedadesPrevias(int pacienteID) throws SQLException{
        conectorBD.conectar();
        ArrayList<String> enfermedadesPrevias = new ArrayList();
        
        String consulta = "select * from EnfermedadesPrevias where Paciente_ID = "+ pacienteID;
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        
        ResultSet resultados = declaracion.executeQuery();
        
        while(resultados.next()){
            enfermedadesPrevias.add(resultados.getString("NombreEnfer"));
        }
        
        conectorBD.desconectar();
        return enfermedadesPrevias;
    }
    
    
}
