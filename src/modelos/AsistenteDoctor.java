package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.DAOs.PacienteDAO;

public class AsistenteDoctor {

    private PacienteDAO pacienteDAO;
    private static AsistenteDoctor asistente;

    private AsistenteDoctor() {
        pacienteDAO = new PacienteDAO();
    }

    public static AsistenteDoctor obtenerUnicoAsistenteDoctor() {
        if (asistente == null) {
            asistente = new AsistenteDoctor();
        }
        return asistente;
    }

    public void actualizarDatosPaciente(Paciente paciente) {
        try {
            pacienteDAO.actualizar(paciente);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
    }

    public Paciente buscarPacientePorId(String id) {
        Paciente pacienteEncontrado = null;
        try {
            pacienteEncontrado = pacienteDAO.getPacientePorID(Integer.valueOf(id));
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
        return pacienteEncontrado;
    }

    public ArrayList<Paciente> buscarPacientesPorNombre(String nombrePaciente) {
        ArrayList<Paciente> pacientesEncontrados = null;
        try {
            pacientesEncontrados = pacienteDAO.getPacientesPorNombre(nombrePaciente);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
        return pacientesEncontrados;
    }

    public ArrayList<Paciente> obtenerListaDePacientesConCita() {
        ArrayList<Paciente> listaPacientesConCita = new ArrayList();
        ArrayList<Paciente> pacientes = obtenerPacientesEnRegistro();
        for (Paciente paciente : pacientes) {
            if (!pacienteAsistidoHoy(paciente) && pacienteConTratamientoActivo(paciente)) {
                listaPacientesConCita.add(paciente);
            }
        }
        return listaPacientesConCita;
    }

    public void ponerAsistenciaAlPaciente(String pacienteID) {
        Paciente paciente = buscarPacientePorId(pacienteID);
        paciente.getTratamiento().getSiguienteAplicacion().setRealizada(true);
        paciente.getTratamiento().getSiguienteAplicacion().setFecha(new Fecha());
        
        pasarAlPacienteAlaEnfermera(paciente);

        crearNuevaCitaAlPaciente(paciente);
    }

    public void registrarNuevoPacienteEnRegistro(Paciente paciente) {
        try {
            pacienteDAO.crearPaciente(paciente);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
    }

    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();
        actualizarAplicacionesDePacienteEnRegistro(paciente);
    }

    private void actualizarAplicacionesDePacienteEnRegistro(Paciente paciente) {
        try {
            pacienteDAO.actualizarAplicaciones(paciente);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
    }

    private ArrayList<Paciente> obtenerPacientesEnRegistro() {
        ArrayList<Paciente> pacientes = new ArrayList();
        try {
            pacientes = pacienteDAO.recuperarTodos();
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
        return pacientes;
    }

    private boolean pacienteAsistidoHoy(Paciente paciente) {
        Fecha fechaHoy = new Fecha();
        boolean pacienteYaPasoHoy = false;
        if (pacientePrimeraCitaAsistida(paciente)) {       
            pacienteYaPasoHoy = paciente.getTratamiento().getUltimaAplicacion().
                getFecha().comperTo(fechaHoy);
        }
        return pacienteYaPasoHoy;
    }

    private boolean pacienteConTratamientoActivo(Paciente paciente) {
        return paciente.getTratamiento().isActivo();
    }

    private boolean pacientePrimeraCitaAsistida(Paciente paciente) {
        return (paciente.getTratamiento().getUltimaAplicacion() != null);
    }
    
    private void pasarAlPacienteAlaEnfermera(Paciente paciente){
        Enfermera.llamarEnfermera().atenderPaciente(paciente.getTratamiento().
                getSiguienteAplicacion().getSuero(), paciente.getTratamiento().getDosis_EDTA_ml());
    }
}
