/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Cita;
import modelos.DAOs.PacienteDAO;
import modelos.Paciente;
import modelos.Persona;
import modelos.Tratamiento;

/**
 *
 * @author miguelangel
 */
public class TestConexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", "Perez", 45, "X", "Merida", "123456789");
        
        ArrayList medicamentos = new ArrayList();
        medicamentos.add("Paracetamol");
        
        ArrayList enfermedades = new ArrayList();
        enfermedades.add("Diabetes");
        
        Tratamiento tratamiento1 = new Tratamiento(125);
        
        Paciente paciente1 = new Paciente(persona1, tratamiento1, enfermedades, medicamentos);
        
        Cita cita = new Cita(paciente1.getClave(), 5);
        
        paciente1.setSiguienteCita(cita);
        
        PacienteDAO pacienteDAO = new PacienteDAO();
        try {
            pacienteDAO.crearPaciente(paciente1);
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la BD " + ex.getMessage());
        }
    }
    
}
