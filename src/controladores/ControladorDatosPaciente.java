/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.AsistenteDoctor;
import modelos.Paciente;

/**
 *
 * @author Milka
 */
public class ControladorDatosPaciente {
    
    public ControladorDatosPaciente(){
        
    }
    
    public void actualizarDatosPaciente(Paciente paciente){
        AsistenteDoctor.obtenerUnicoAsistenteDoctor().actualizarPaciente(paciente);
    }
}
