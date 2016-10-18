/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Paciente;
import modelos.Persona;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class PacienteDAO {
    private ConectorBD conectorBD;
    
    public PacienteDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public void crearPaciente(Paciente paciente) throws SQLException{
        conectorBD.conectar();
        String campos = "Nombre, Apellido, Direccion, Localidad, Telefono, "
                +"Edad, ClvPaciente, EnfermedadesPrevias, MedicamentosExternos";
        
        String consulta = "INSERT INTO Paciente ("+campos+")"+" VALUES (?,?,?,?,?,?,?,?,?, ?)";        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        declaracion.setString(1, paciente.getNombres());
        declaracion.setString(2, paciente.getApellidos());
        declaracion.setString(3, paciente.getDireccion());
        declaracion.setString(4, paciente.getLocalidad());
        declaracion.setString(5, paciente.getTelefono());
        declaracion.setInt(6, paciente.getEdad());
        declaracion.setString(7, paciente.getClave());
        declaracion.setInt(8, paciente.getEnfermedadesPrevias().size());
        declaracion.setInt(9, paciente.getMedicamentosExternos().size());
        
        java.sql.Date fechaDeInscripcion = new java.sql.Date(paciente.getFechaDeInscripcion().getTime());
        declaracion.setDate(10, fechaDeInscripcion);
        
        String camposEnfermedades = "clvPaciente, NumEnfer, NombreEnfer";
        consulta = "INSERT INTO EnfermedadesPrevias ("+camposEnfermedades+")" +
                " VALUES (?, ?, ?)";
        PreparedStatement declaracionEnfermedades = conectorBD.consulta(consulta);
        declaracionEnfermedades.setString(1, paciente.getClave());
        for (int i = 0; i < paciente.getEnfermedadesPrevias().size(); i++) {
            declaracionEnfermedades.setInt(2, i);
            declaracionEnfermedades.setString(3, paciente.getEnfermedadesPrevias().get(i));
        }
        
        String camposMedicamentos = "clvPaciente, numMedicamento, NombreMedicamento";
        consulta = "INSERT INTO MedicamentosExternos ("+camposMedicamentos+")" + 
                " VALUES (?,?,?)";
        PreparedStatement declaracionMedicamentos = conectorBD.consulta(consulta);
        declaracionMedicamentos.setString(1, paciente.getClave());
        for (int i = 0; i < paciente.getMedicamentosExternos().size(); i++) {
            declaracionMedicamentos.setInt(2, i);
            declaracionMedicamentos.setString(3, paciente.getMedicamentosExternos().get(i));
        }
        
        declaracion.execute();
        declaracionEnfermedades.execute();
        declaracionMedicamentos.execute();
        conectorBD.desconectar();
    }
    
    public Paciente getPaciente(String clvPaciente) throws SQLException{
        this.conectorBD.conectar();
        
        ResultSet resultado = null;
        String consulta = "select * from Pacientes where ClvPaciente = " + clvPaciente;
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);
        
        resultado = declaracionDeRecuperacion.executeQuery();
        
        Persona persona = new Persona(resultado.getString("Nombre"), resultado.getString("Apellido"),
        resultado.getInt("Edad"), resultado.getString("Direccion"), resultado.getString("Localidad"), 
        resultado.getString("Telefono"));
        
        Paciente paciente = new Paciente(persona);
        paciente.setClave(resultado.getString("ClvPaciente"));
        
        return paciente;
    }
}
