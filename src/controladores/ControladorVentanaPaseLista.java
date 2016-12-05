
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
    
    public void mandarAAsistenteIDPacienteConAsistencia(String pacienteID) {
        asistente.ponerAsistenciaAlPaciente(pacienteID);
    }

    public void mandarARecepcionistaPacientesConCita() {
        RecepcionistaVentanaPaseLista.obtenerRecepcionista().
            recibirPacientesConCita(asistente.obtenerListaDePacientesConCita());
    }


}
