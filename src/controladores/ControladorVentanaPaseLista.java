/*
    La siguiente clase enlaza a la clase VentanillaPaseDeLista con la clase 
    AsistenteDoctor, de tal forma, cuando el usuario hiciera cambios en la 
    la VentanillaPaseDeLista, esta clase mandará los cambios a hacer a la clase
    AsistenteDoctor
*/

package controladores;

import modelos.AsistenteDoctor;
import vistas.RecepcionistaVentanaPaseLista;

public class ControladorVentanaPaseLista {

    private final AsistenteDoctor asistente;
    private static ControladorVentanaPaseLista controlador;
    
    private ControladorVentanaPaseLista() {
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }
   
    public static ControladorVentanaPaseLista obtenerControlador(){
        if (controlador == null) {
            controlador = new ControladorVentanaPaseLista();
        }
        return controlador;
    }

    public void mandarARecepcionistaPacientesConCita() {
        RecepcionistaVentanaPaseLista.obtenerRecepcionista().
            recibirPacientesConCita(asistente.obtenerListaDePacientesConCita());
    }

    public void mandarAAsistenteIDPacienteConAsistencia(String pacienteID) {
        asistente.ponerAsistenciaAlPaciente(pacienteID);
    }

}
