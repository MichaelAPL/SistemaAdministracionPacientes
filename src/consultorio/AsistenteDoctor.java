package consultorio;

import java.util.ArrayList;
import java.util.Date;
import ventanillas.VentanillaPaseDeLista;

/**
 *
 * @author Milka
 */
public class AsistenteDoctor {

    VentanillaPaseDeLista ventanillaPaseLista;
    ArrayList<Paciente> bancoDePacientes;
    ArrayList<Paciente> pacientesConCitaHoy;
    
    public AsistenteDoctor(){
        pacientesConCitaHoy = generarListaDePacientesConCitaHoy();
    }

    public ArrayList<Paciente> generarListaDePacientesConCitaHoy() {
        ArrayList<Paciente> listaDePacientesConCitaHoy = new ArrayList();
        Date fechaHoy = new Date();
        for (Paciente paciente : bancoDePacientes) {
            if (paciente.getSiguienteCita().getFechaProgramada().equals(fechaHoy)) {
                listaDePacientesConCitaHoy.add(paciente);
            }
        }
        return listaDePacientesConCitaHoy;
    }

    public void mandarAVentanillaAPacientesConCitas() {
        ventanillaPaseLista.crearListaDeCitasHoy(pacientesConCitaHoy);
    }

    public void ponerAsistenciaYCrearNuevaCitaAlPaciente(int numeroDePacienteEnLaLista) {
        Paciente paciente = pacientesConCitaHoy.remove(numeroDePacienteEnLaLista);
        paciente.getSiguienteCita().setRealizada(true);
        Cita cita = new Cita(paciente.getSiguienteCita().getNumeroDeCita()+1);
        paciente.setSiguienteCita(cita);
    }

}
