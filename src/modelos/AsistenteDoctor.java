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

    public AsistenteDoctor(ArrayList<Paciente> pacientes, VentanillaPaseDeLista ventanillaPaseLista) {
        this.bancoDePacientes = pacientes;
        this.pacientesConCitaHoy = generarListaDePacientesConCitaHoy();
        this.ventanillaPaseLista = ventanillaPaseLista;
    }

    public ArrayList<Paciente> generarListaDePacientesConCitaHoy() {
        ArrayList<Paciente> listaPacientesConCita = new ArrayList();
        Date fechaHoy = new Date();

        for (Paciente paciente : bancoDePacientes) {
            boolean pacienteYaPasoHoy;
            boolean pacienteConTratamientoActivo;
            if (paciente.getTratamiento().getUltimaAplicacion() != null) {
                pacienteYaPasoHoy = paciente.getTratamiento().
                        getUltimaAplicacion().getFecha().equals(fechaHoy);
            } else {
                pacienteYaPasoHoy = false;
            }
            
            pacienteConTratamientoActivo = paciente.getTratamiento().
                    isActivo();

            if (!pacienteYaPasoHoy && pacienteConTratamientoActivo) {
                listaPacientesConCita.add(paciente);
            }

        }
        return listaPacientesConCita;
    }

    public void mandarAVentanillaAPacientesConCitas() {
        ventanillaPaseLista.crearListaDeCitasHoy(pacientesConCitaHoy);
    }

    public void ponerAsistenciaAlPaciente(int numeroDePacienteEnLaLista) {
        Paciente paciente = pacientesConCitaHoy.remove(numeroDePacienteEnLaLista);
        paciente.getTratamiento().getSiguienteAplicacion().setRealizada(true);

        crearNuevaCitaAlPaciente(paciente);
    }

    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();

    }
}
