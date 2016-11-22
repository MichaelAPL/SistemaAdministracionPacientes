/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.AsistenteDoctor;
import vistas.VentanaBusqueda;
import vistas.VentanaDatosPaciente;

/**
 *
 * @author Milka
 */
public class ControladorBusqueda {

    private final AsistenteDoctor asistente;
    

    public ControladorBusqueda() {
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }
    public void mandarAVentanaBusquedaPacientesEncontrados(String nombresPaciente) {
        VentanaBusqueda.obtenerUnicaVentanaBusqueda().
            mostrarPacientes(asistente.buscarPacientesPorNombre(nombresPaciente));
    }

    public void obtencionDatosPaciente(String idPaciente) {
        VentanaDatosPaciente.obtenerUnicaVentanaDatosPaciente().
            mostrarDatosPaciente(asistente.buscarPacientePorId(idPaciente));

    }

}
