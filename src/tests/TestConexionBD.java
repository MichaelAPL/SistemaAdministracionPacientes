/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Aplicacion;
import modelos.DAOs.AplicacionDAO;
import modelos.DAOs.PacienteDAO;
import modelos.DAOs.TratamientoDAO;
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
        Persona persona2 = new Persona("Juan", "Lopez", 50, "Y", "Merida", "987654321");
        
        ArrayList medicamentos = new ArrayList();
        medicamentos.add("Paracetamol");
        medicamentos.add("Medicina2");
        medicamentos.add("Medicina3");
        
        ArrayList enfermedades = new ArrayList();
        enfermedades.add("Diabetes");
        enfermedades.add("enfermedad2");
        enfermedades.add("enfermedad3");
        
        Tratamiento tratamiento1 = new Tratamiento(125);
        Tratamiento tratamiento2 = new Tratamiento(115);
        
        Paciente paciente1 = new Paciente(persona1, medicamentos, enfermedades, tratamiento1);
        Paciente paciente2 = new Paciente(persona2, medicamentos, enfermedades, tratamiento2);
                        
        try {   
            PacienteDAO pacienteDAO = new PacienteDAO();
            
            
            //pacienteDAO.crearPaciente(paciente1);
            //pacienteDAO.crearPaciente(paciente2);
            
            ResultSet pacientes = pacienteDAO.recuperarTodos();
            
            TratamientoDAO tratamientoDAO = new TratamientoDAO();
            AplicacionDAO aplicacionDAO = new AplicacionDAO();
            
            while(pacientes.next()){
                Tratamiento tratamiento = tratamientoDAO.getTratamiento(pacientes.getInt("ID_Paciente"));
                System.out.println("ID: " + pacientes.getInt("ID_Paciente"));
                System.out.println("Nombre: "+pacientes.getString("Nombre"));
                System.out.println(tratamiento.getPaciente_id());
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
}
