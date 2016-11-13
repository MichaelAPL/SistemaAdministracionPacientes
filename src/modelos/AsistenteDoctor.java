package modelos;

import java.util.ArrayList;
import java.util.Date;
import vistas.VentanaPaseLista;

/**
 *
 * @author Milka
 */
public class AsistenteDoctor {

    private VentanaPaseLista ventanillaPaseLista;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Paciente> pacientesConCitaHoy;

    public AsistenteDoctor(ArrayList<Paciente> pacientes, VentanaPaseLista ventanillaPaseLista) {
        this.pacientes = pacientes;
        this.pacientesConCitaHoy = generarListaDePacientesConCita();
        this.ventanillaPaseLista = ventanillaPaseLista;
    }

    public ArrayList<Paciente> generarListaDePacientesConCita() {
        ArrayList<Paciente> listaPacientesConCita = new ArrayList();

        for (Paciente paciente : pacientes) {
            if (!pacienteAsistidoHoy(paciente) && pacienteConTratamientoActivo(paciente)) {
                listaPacientesConCita.add(paciente);
            }
        }
        return listaPacientesConCita;
    }
    
    private boolean pacienteConTratamientoActivo(Paciente paciente){
        return paciente.getTratamiento().isActivo();
    }

    private boolean pacientePrimeraCitaAsistida(Paciente paciente){
        return (paciente.getTratamiento().getUltimaAplicacion() != null);
    }
    
    private boolean pacienteAsistidoHoy(Paciente paciente){
        Date fechaHoy = new Date();
        boolean pacienteYaPasoHoy = false;
        
            if (pacientePrimeraCitaAsistida(paciente)) {
                pacienteYaPasoHoy = paciente.getTratamiento().
                        getUltimaAplicacion().getFecha().equals(fechaHoy);
            }
            return pacienteYaPasoHoy;
    }
    
    public void mandarAVentanillaAPacientesConCitas() {
        ventanillaPaseLista.mostrarPacientesConCita(pacientesConCitaHoy);
    }

    public void ponerAsistenciaAlPaciente(int numeroDePacienteEnLaLista) {
        Paciente paciente = pacientesConCitaHoy.remove(numeroDePacienteEnLaLista);
        paciente.getTratamiento().getSiguienteAplicacion().setRealizada(true);
        paciente.getTratamiento().getSiguienteAplicacion().setFecha(new Date ());

        crearNuevaCitaAlPaciente(paciente);
    }

    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();

    }
}
