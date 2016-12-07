package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
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
            MensajesDeDialogo.mostrarMensajeDatosGuardadosExitosamente();
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
    }

    public Paciente buscarPacientePorId(String id) {
        Paciente pacienteEncontrado = null;
        try {
            pacienteEncontrado = pacienteDAO.obtenerPacientePorID(Integer.valueOf(id));
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
        return pacienteEncontrado;
    }

    public ArrayList<Paciente> buscarPacientesPorNombre(String nombrePaciente) {
        ArrayList<Paciente> pacientesEncontrados = null;
        try {
            pacientesEncontrados = pacienteDAO.obtenerPacientesPorNombre(nombrePaciente);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
        return pacientesEncontrados;
    }

    public ArrayList<Paciente> obtenerListaDePacientesConCita() {
        ArrayList<Paciente> listaPacientesConCita = new ArrayList();
        ArrayList<Paciente> pacientes = obtenerPacientesEnRegistro();
        for (Paciente paciente : pacientes) {
            if (!asistioPacienteACita(paciente) && tienePacienteTratamientoActivo(paciente)) {
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
        pasarAlContadorPagoPaciente();

        crearNuevaCitaAlPaciente(paciente);
    }

    public void registrarNuevoPacienteEnRegistro(Paciente paciente) {
        try {
            pacienteDAO.crearPaciente(paciente);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
    }

    private void actualizarAplicacionesDePacienteEnRegistro(Paciente paciente) {
        try {
            pacienteDAO.actualizar(paciente);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
    }
    
    private boolean asistioPacienteACita(Paciente paciente) {
        Fecha fechaHoy = new Fecha();
        boolean pacienteYaPasoHoy = false;
        if (asistioPacienteAPrimeraCita(paciente)) {       
            pacienteYaPasoHoy = paciente.getTratamiento().getUltimaAplicacion().
                getFecha().comperTo(fechaHoy);
        }
        
        return pacienteYaPasoHoy;
    }

    private boolean asistioPacienteAPrimeraCita(Paciente paciente) {
        return (paciente.getTratamiento().getUltimaAplicacion() != null);
    }
    
    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();
        actualizarAplicacionesDePacienteEnRegistro(paciente);
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
    
    private void pasarAlContadorPagoPaciente() {
        Contador.llamarContador().cobrarPaciente();
    }
    
    private void pasarAlPacienteAlaEnfermera(Paciente paciente){
        Enfermera.llamarEnfermera().atenderPaciente(paciente);
    }

    private boolean tienePacienteTratamientoActivo(Paciente paciente) {
        return paciente.getTratamiento().isActivo();
    }
  
}
