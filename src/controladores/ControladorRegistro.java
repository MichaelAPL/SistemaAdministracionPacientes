package controladores;

import java.sql.SQLException;
import modelos.enums.DatosPaciente;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.DAOs.PacienteDAO;
import modelos.Paciente;
import modelos.Persona;
import modelos.Tratamiento;

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
