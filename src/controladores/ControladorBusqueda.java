/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.AsistenteDoctor;

/**
 *
 * @author Milka
 */
public class ControladorBusqueda {

    private AsistenteDoctor asistente;
    

    public ControladorBusqueda() {
        
    }
    
    public void setAsistente(AsistenteDoctor asistente){
        this.asistente = asistente;
    }
    
    public void busquedaPaciente(String nombresPaciente) {
        asistente.buscarPaciente(nombresPaciente);
    }

    public void obtencionDatosPaciente(String nombresYApellidosPaciente) {
        
    }

}
