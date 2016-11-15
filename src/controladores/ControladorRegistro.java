package controladores;

import java.sql.SQLException;
import modelos.DAOs.PacienteDAO;
import modelos.Paciente;

/**
 *
 * @author Milka
 */
public class ControladorRegistro {
    
    private PacienteDAO pacienteDAO;
    
    public ControladorRegistro(){
        this.pacienteDAO = new PacienteDAO();
    }
    
    public void crearNuevoPaciente(Paciente paciente){
        try {
            pacienteDAO.crearPaciente(paciente);
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la Base de Datos");
        }
    }
}
