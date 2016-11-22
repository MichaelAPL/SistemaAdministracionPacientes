package controladores;


import modelos.AsistenteDoctor;
import modelos.Paciente;

/**
 *
 * @author Milka
 */
public class ControladorRegistro {
    
    AsistenteDoctor asistente;
    
    public ControladorRegistro(){
        asistente = AsistenteDoctor.obtenerUnicoAsistenteDoctor();
    }
    
    public void mandarAAsistenteNuevoPaciente(Paciente paciente){
        asistente.registrarNuevoPacienteEnRegistro(paciente);
    }
}
