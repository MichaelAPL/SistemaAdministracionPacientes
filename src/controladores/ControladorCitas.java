/*
    La siguiente clase enlaza a la clase VentanillaPaseDeLista con la clase 
    AsistenteDoctor, de tal forma, cuando el usuario hiciera cambios en la 
    la VentanillaPaseDeLista, esta clase mandará los cambios a hacer a la clase
    AsistenteDoctor
*/

package controladores;

import modelos.AsistenteDoctor;

public class ControladorCitas {

    AsistenteDoctor asistente;

    public ControladorCitas() {
    }

    public void actualizarListaPacientes() {
        asistente.mandarAVentanillaAPacientesConCitas();
    }

    public void asistenciaDePacientes(int indicePaciente) {
        asistente.ponerAsistenciaAlPaciente(indicePaciente);
    }

    public void setAsistente(AsistenteDoctor asistente) {
        this.asistente = asistente;
    }

}
