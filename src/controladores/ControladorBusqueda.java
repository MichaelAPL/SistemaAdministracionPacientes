/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.AsistenteDoctor;
import vistas.RecepcionistaVentanaBusqueda;
import vistas.VentanaBusqueda;
import vistas.VentanaDatosPaciente;

/**
 *
 * @author Milka
 */
public class ControladorBusqueda {

    private final AsistenteDoctor asistente;
    private static ControladorBusqueda controlador;
    

    private ControladorBusqueda() {
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }
    
    public static ControladorBusqueda obtenerControlador(){
        if (controlador == null) {
            controlador = new ControladorBusqueda();
        }
        return controlador;
    }
    
    public void llamarARecepcionista(){
        RecepcionistaVentanaBusqueda.obtenerRecepcionista();
    }
    
    public void mandarAVentanaBusquedaPacientesEncontrados(String nombresPaciente) {
        RecepcionistaVentanaBusqueda.obtenerRecepcionista().
            mostrarPacientes(asistente.buscarPacientesPorNombre(nombresPaciente));
    }

    public void obtencionDatosPaciente(String idPaciente) {
        VentanaDatosPaciente.obtenerUnicaVentanaDatosPaciente().
            mostrarDatosPaciente(asistente.buscarPacientePorId(idPaciente));

    }

}
