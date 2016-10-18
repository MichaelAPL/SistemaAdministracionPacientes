package modelos;

import java.util.ArrayList;
import java.util.Date;
import vistas.VentanillaPaseDeLista;

/**
 *
 * @author Milka
 */
public class AsistenteDoctor {

    private VentanillaPaseDeLista ventanillaPaseLista;
    private ArrayList<Paciente> bancoDePacientes;
    private ArrayList<Paciente> pacientesConCitaHoy;
    
    public AsistenteDoctor(ArrayList<Paciente> pacientes, VentanillaPaseDeLista ventanillaPaseLista){
        this.bancoDePacientes = pacientes;
        this.pacientesConCitaHoy = generarListaDePacientesConCitaHoy();
        this.ventanillaPaseLista = ventanillaPaseLista;
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

    public void ponerAsistenciaAlPaciente(int numeroDePacienteEnLaLista) {
        Paciente paciente = pacientesConCitaHoy.remove(numeroDePacienteEnLaLista);
        paciente.getSiguienteCita().setRealizada(true);
        paciente.getTratamiento().agregarSueroAlHistorial();
        
        crearNuevaCitaAlPaciente(paciente);
    }
    
    private void crearNuevaCitaAlPaciente(Paciente paciente){
        Cita cita = new Cita(paciente.getClave(), 
                paciente.getSiguienteCita().getNumeroDeCita()+1);
        paciente.setSiguienteCita(cita);
    }
}
