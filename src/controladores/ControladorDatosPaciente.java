
package controladores;

import modelos.AsistenteDoctor;
import modelos.Paciente;
import vistas.RecepcionistaVentanaDatosPaciente;

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
    
    public void mandarARecepcionistaIDPaciente(String idPaciente){
        RecepcionistaVentanaDatosPaciente.obtenerRecepcionista().
            mostrarDatosPaciente(asistente.buscarPacientePorId(idPaciente));
    }
}
