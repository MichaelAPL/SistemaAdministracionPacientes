/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.AsistenteDoctor;
import modelos.Paciente;
import vistas.RecepcionistaVentanaDatosPaciente;

/**
 *
 * @author Milka
 */
public class ControladorDatosPaciente {
    
    private static ControladorDatosPaciente controlador;
    private AsistenteDoctor asistente;
    
    public ControladorDatosPaciente(){
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }
    
    public static ControladorDatosPaciente obtenerControlador(){
        if (controlador == null) {
            controlador = new ControladorDatosPaciente();
        }
        return controlador;
    }
    
    public void mandarAAsistenteDatosPacienteAActualizar(Paciente paciente){
        asistente.actualizarDatosPaciente(paciente);
    }
    
    public void mandarARecepcionistaPaciente(String idPaciente){
        RecepcionistaVentanaDatosPaciente.obtenerRecepcionista().
            mostrarDatosPaciente(asistente.buscarPacientePorId(idPaciente));
    }
}
