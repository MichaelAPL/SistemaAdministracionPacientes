/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelos.DAOs.CitaDAO;
import modelos.DAOs.PacienteDAO;
import modelos.DAOs.TratamientoDAO;
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
        
        tratamiento1.setClavePaciente(paciente1.getClave());
        
        Cita cita = new Cita(paciente1.getClave(), 5);
        cita.setFechaDeRealizacion(new Date());
        
        paciente1.setSiguienteCita(cita);
        
        PacienteDAO pacienteDAO = new PacienteDAO();
        TratamientoDAO tratamientoDAO = new TratamientoDAO();
        CitaDAO citaDAO = new CitaDAO();
        
        try {
            pacienteDAO.crearPaciente(paciente1);
            citaDAO.crearCita(cita);
            tratamientoDAO.crearTratamiento(paciente1.getTratamiento());
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la BD " + ex.getMessage());
        }
    }
    
}
