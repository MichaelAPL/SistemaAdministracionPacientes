package controladores;


import modelos.AsistenteDoctor;
import modelos.Paciente;
import vistas.RecepcionistaVentanaRegistroPaciente;

/**
 *
 * @author Milka
 */
public class ControladorRegistro {
    
    private AsistenteDoctor asistente;
    private static ControladorRegistro controlador;

    private ControladorRegistro(){
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }
    
    public static ControladorRegistro obtenerControlador(){
        if (controlador == null) {
            controlador =  new ControladorRegistro();
        }
        return controlador;
    }
    
    public void mandarAAsistenteNuevoPaciente(Paciente paciente){
        asistente.registrarNuevoPacienteEnRegistro(paciente);
    }
    
    public void llamarRecepcionista(){
        RecepcionistaVentanaRegistroPaciente.obtenerRecepcionista();
    }
}
