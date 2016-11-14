/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelos.Paciente;
import modelos.AsistenteDoctor;
import modelos.Persona;
import modelos.Tratamiento;
import java.util.ArrayList;
import vistas.VentanaPaseLista;



/**
 *
 * @author Milka
 */
public class TestSeguimientoCitas {

    public static void main(String[] args) {
        /*ControladorRegistro controlRegistro = new ControladorRegistro();
        VentanaRegistroPacientes ventanaRegistro = new VentanaRegistroPacientes(controlRegistro);
     
        ventanaRegistro.setVisible(true);*/
        VentanaPaseLista ventanillaPaseLista = new VentanaPaseLista();
        ArrayList<Paciente> bancoPacientes = new ArrayList();
        
        Persona persona1 = new Persona("Juan", "Perez", "X", "Merida", "123456789", 45);
        Persona persona2 = new Persona("Julio", "Gamboa", "X", "Merida", "123546789", 70);
        
        ArrayList medicamentos = new ArrayList();
        medicamentos.add("Paracetamol");
        
        ArrayList enfermedades = new ArrayList();
        enfermedades.add("Diabetes");
        
        Tratamiento tratamiento1 = new Tratamiento(125);
        Tratamiento tratamiento2 = new Tratamiento(145);
        
        Paciente paciente1 = new Paciente(persona1, enfermedades, medicamentos, tratamiento1);
        
        Paciente paciente2 = new Paciente(persona2, enfermedades, medicamentos, tratamiento2);
        
        bancoPacientes.add(paciente1);
        bancoPacientes.add(paciente2);
        
        AsistenteDoctor asistente = new AsistenteDoctor(bancoPacientes, ventanillaPaseLista);
        asistente.mandarAVentanillaAPacientesConCitas();
        
        ventanillaPaseLista.setAsistenteDoctor(asistente);
    }   
}
