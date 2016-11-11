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
    private ArrayList<Paciente> pacientes;
    private ArrayList<Paciente> pacientesConCitaHoy;

    public AsistenteDoctor(ArrayList<Paciente> pacientes, VentanillaPaseDeLista ventanillaPaseLista) {
        this.pacientes = pacientes;
        this.pacientesConCitaHoy = generarListaDePacientesConCita();
        this.ventanillaPaseLista = ventanillaPaseLista;
    }

    public ArrayList<Paciente> generarListaDePacientesConCita() {
        ArrayList<Paciente> listaPacientesConCita = new ArrayList();
        Date fechaHoy = new Date();

        for (Paciente paciente : pacientes) {
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
