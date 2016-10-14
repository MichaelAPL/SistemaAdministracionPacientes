/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cita;
import modelos.DAOs.PacienteDAO;
import modelos.Paciente;
import modelos.Persona;
import modelos.Tratamiento;
import modelos.database.ConectorBD;

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
        
        Cita cita = new Cita(5);
        
        Tratamiento tratamiento1 = new Tratamiento(125);
        
        Paciente paciente1 = new Paciente(persona1, tratamiento1, enfermedades, medicamentos);
        paciente1.setSiguienteCita(cita);
        
        PacienteDAO pacienteDAO = new PacienteDAO();
        try {
            pacienteDAO.crearPaciente(paciente1);
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la BD " + ex.getMessage());
        }
    }
    
}
