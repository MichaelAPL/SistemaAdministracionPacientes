/*
    La siguiente clase enlaza a la clase VentanillaPaseDeLista con la clase 
    AsistenteDoctor, de tal forma, cuando el usuario hiciera cambios en la 
    la VentanillaPaseDeLista, esta clase mandará los cambios a hacer a la clase
    AsistenteDoctor
*/

package controladores;

import modelos.AsistenteDoctor;
import vistas.VentanaPaseLista;

public class ControladorVentanaPaseLista {

    private final AsistenteDoctor asistente;

    public ControladorVentanaPaseLista() {
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }

    public void mandarAventanaPacientesConCita() {
        VentanaPaseLista.obtenerUnicaVentana().
            mostrarPacientesConCita(asistente.obtenerListaDePacientesConCita());
    }

    public void mandarAAsistentePacienteConAsistencia(String pacienteID) {
        asistente.ponerAsistenciaAlPaciente(pacienteID);
        //mandarAventanaPacientesConCita();
    }

}
