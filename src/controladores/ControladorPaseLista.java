
package controladores;

import modelos.AsistenteDoctor;
import vistas.RecepcionistaVentanaPaseLista;

public class ControladorPaseLista {

    private final AsistenteDoctor asistente;
    private static ControladorPaseLista controlador;
    
    private ControladorPaseLista() {
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }
   
    public static ControladorPaseLista obtenerControlador(){
        if (controlador == null) {
            controlador = new ControladorPaseLista();
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
