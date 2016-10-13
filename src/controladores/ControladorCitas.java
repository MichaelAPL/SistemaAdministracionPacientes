
package controladores;

import modelos.AsistenteDoctor;



/**
 *
 * @author Milka
 */
public class ControladorCitas {
    
    AsistenteDoctor asistente;
    
    public ControladorCitas(){
    }

    public void setAsistente(AsistenteDoctor asistente){
        this.asistente = asistente;
    }
    
    public void asistenciaDePacientes(int indicePaciente){
        asistente.ponerAsistenciaAlPaciente(indicePaciente);
    }
    
    public void actualizarListaPacientes(){
        asistente.mandarAVentanillaAPacientesConCitas();
    }
}
