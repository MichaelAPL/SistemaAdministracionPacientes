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

    private boolean pacienteConTratamientoActivo(Paciente paciente) {
        return paciente.getTratamiento().isActivo();
    }

    private boolean pacientePrimeraCitaAsistida(Paciente paciente) {
        return (paciente.getTratamiento().getUltimaAplicacion() != null);
    }

    private boolean pacienteAsistidoHoy(Paciente paciente) {
        Date fechaHoy = new Date();
        boolean pacienteYaPasoHoy = false;

        if (pacientePrimeraCitaAsistida(paciente)) {
            int dia = paciente.getTratamiento().getUltimaAplicacion().getFecha().getDate();
            int mes = paciente.getTratamiento().getUltimaAplicacion().getFecha().getMonth();
            int año = paciente.getTratamiento().getUltimaAplicacion().getFecha().getYear();
            pacienteYaPasoHoy = ((dia == fechaHoy.getDate()) && (mes == fechaHoy.getMonth()) && (año == fechaHoy.getYear()));
        }
        return pacienteYaPasoHoy;
    }

    public void mandarAVentanillaAPacientesConCitas() {
        pacientesConCitaHoy = generarListaDePacientesConCita();
        ventanillaPaseLista.mostrarPacientesConCita(pacientesConCitaHoy);
    }

    public void ponerAsistenciaAlPaciente(int numeroDePacienteEnLaLista) {
        //for (int i = 0; i < numeroDePacienteEnLaLista.size(); i++) {
            Paciente paciente = pacientesConCitaHoy.get(numeroDePacienteEnLaLista);
            paciente.getTratamiento().getSiguienteAplicacion().setRealizada(true);
            paciente.getTratamiento().getSiguienteAplicacion().setFecha(new Date());

            crearNuevaCitaAlPaciente(paciente);
        //}
    }

    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();

    }
}
