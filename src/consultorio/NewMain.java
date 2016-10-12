/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import gestoresDeVentanillas.ControladorRegistro;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ventanillas.VentanillaPaseDeLista;



/**
 *
 * @author Milka
 */
public class NewMain {

    public static void main(String[] args) {
        /*ControladorRegistro controlRegistro = new ControladorRegistro();
        VentanaRegistroPacientes ventanaRegistro = new VentanaRegistroPacientes(controlRegistro);
        
=======
        ventanaRegistro.setVisible(true);*/
        
        VentanillaPaseDeLista ventanillaPaseLista = new VentanillaPaseDeLista();
        ArrayList<Paciente> bancoPacientes = new ArrayList();
        
        Persona persona1 = new Persona("Juan", "Perez", 45, "X", "Merida", "123456789");
        Persona persona2 = new Persona("Julio", "Gamboa", 70, "X", "Merida", "123546789");
        
        ArrayList medicamentos = new ArrayList();
        medicamentos.add("Paracetamol");
        
        ArrayList enfermedades = new ArrayList();
        enfermedades.add("Diabetes");
        
        Cita cita = new Cita(1);
        
        Paciente paciente1 = new Paciente(persona1, 125, enfermedades, medicamentos);
        paciente1.setSiguienteCita(cita);
        
        Paciente paciente2 = new Paciente(persona2, 145, enfermedades, medicamentos);
        paciente2.setSiguienteCita(cita);
        
        bancoPacientes.add(paciente1);
        bancoPacientes.add(paciente2);
        
        AsistenteDoctor asistente = new AsistenteDoctor(bancoPacientes, ventanillaPaseLista);
        asistente.mandarAVentanillaAPacientesConCitas();
        
        ventanillaPaseLista.setAsistenteControlador(asistente);
    }
    
}
