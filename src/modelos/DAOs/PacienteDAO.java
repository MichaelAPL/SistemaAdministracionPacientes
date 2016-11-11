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
    private MedicamentosExternosDAO medicamentosExternosDAO;
    private EnfermedadesPreviasDAO enfermedadesPreviasDAO;
    
    
    public PacienteDAO(){
        this.conectorBD = new ConectorBD();
        medicamentosExternosDAO = new MedicamentosExternosDAO();
        enfermedadesPreviasDAO = new EnfermedadesPreviasDAO();
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
        
        declaracion.execute();
        
        enfermedadesPreviasDAO.crearEnfermedadesPrevias(paciente);
        medicamentosExternosDAO.crearMedicamentosExternos(paciente);
        
        conectorBD.desconectar();
    }
    
    public Paciente getPaciente(int Paciente_ID) throws SQLException{
        this.conectorBD.conectar();
        
        ResultSet resultado = null;
        String consulta = "select * from Pacientes where ID_Paciente = ?";
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
