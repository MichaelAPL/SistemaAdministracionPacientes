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
import modelos.enums.DatosPacienteDao;

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
                + "Edad, ID_Paciente, EnfermedadesPrevias, MedicamentosExternos, "
                + "FechaInscripcion";
        
        String consulta = "INSERT INTO Paciente ("+campos+")"+" VALUES (?,?,?,?,?,?,?,?,?,?)";  
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        declaracion.setString( DatosPacienteDao.NOMBRE.getDato(), paciente.getNombres() );
        declaracion.setString( DatosPacienteDao.APELLIDO.getDato(), paciente.getApellidos() );
        declaracion.setString( DatosPacienteDao.DIRECCION.getDato(), paciente.getDireccion() );
        declaracion.setString( DatosPacienteDao.LOCALIDAD.getDato(), paciente.getLocalidad() );
        declaracion.setString( DatosPacienteDao.TELEFONO.getDato(), paciente.getTelefono() );
        declaracion.setInt( DatosPacienteDao.EDAD.getDato(), paciente.getEdad() );
        declaracion.setInt( DatosPacienteDao.ENFERMEDADES_PREVIAS.getDato(), paciente.getEnfermedadesPrevias().size() );
        declaracion.setInt( DatosPacienteDao.MEDICAMENTOS_EXTERNOS.getDato(), paciente.getMedicamentosExternos().size() );
        
        java.sql.Date fechaDeInscripcion = new java.sql.Date(paciente.getFechaDeInscripcion().getTime());
        declaracion.setDate( DatosPacienteDao.FECHA_INSCRIPCION.getDato(), fechaDeInscripcion );
        
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
    
    public Paciente getPaciente(int Paciente_ID) throws SQLException{
        this.conectorBD.conectar();
        
        ResultSet resultado = null;
        String consulta = "select * from Pacientes where Paciente_ID = ?";
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);
        declaracionDeRecuperacion.setInt(1, Paciente_ID);
        
        resultado = declaracionDeRecuperacion.executeQuery();
        
        Persona persona = new Persona(resultado.getString("Nombre"), resultado.getString("Apellido"),
        resultado.getInt("Edad"), resultado.getString("Direccion"), resultado.getString("Localidad"), 
        resultado.getString("Telefono"));
        
        Paciente paciente = new Paciente(persona);
        paciente.setClave(resultado.getString("ClvPaciente"));
        
        this.conectorBD.desconectar();
        
        return paciente;
    }
}
