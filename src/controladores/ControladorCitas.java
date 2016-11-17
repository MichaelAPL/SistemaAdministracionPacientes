/*
    La siguiente clase enlaza a la clase VentanillaPaseDeLista con la clase 
    AsistenteDoctor, de tal forma, cuando el usuario hiciera cambios en la 
    la VentanillaPaseDeLista, esta clase mandará los cambios a hacer a la clase
    AsistenteDoctor
*/

package controladores;

import modelos.AsistenteDoctor;

public class ControladorCitas {

    private final AsistenteDoctor asistente;

    public ControladorCitas() {
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }

    public void actualizarListaPacientes() {
        asistente.mandarAVentanaAPacientesConCitas();
    }

    public void asistenciaDePacientes(String pacienteID) {
        asistente.ponerAsistenciaAlPaciente(pacienteID);
    }

}
