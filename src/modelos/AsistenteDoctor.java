package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paciente buscarPacientePorId(String id) {
        Paciente pacienteEncontrado = null;
        try {
            pacienteEncontrado = pacienteDAO.getPacientePorID(Integer.valueOf(id));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pacienteEncontrado;
    }

    public ArrayList<Paciente> buscarPacientesPorNombre(String nombrePaciente) {
        ArrayList<Paciente> pacientesEncontrados = null;
        try {
            pacientesEncontrados = pacienteDAO.getPacientesPorNombre(nombrePaciente);
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        paciente.getTratamiento().getSiguienteAplicacion().setFecha(new Date());

        crearNuevaCitaAlPaciente(paciente);
    }

    public void registrarNuevoPacienteEnRegistro(Paciente paciente) {
        try {
            pacienteDAO.crearPaciente(paciente);
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la Base de Datos");
        }
    }

    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();
        actualizarAplicacionesDePacienteEnRegistro(paciente);
    }

    private void actualizarAplicacionesDePacienteEnRegistro(Paciente paciente) {
        try {
            pacienteDAO.actualizarAplicaciones(paciente);
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<Paciente> obtenerPacientesEnRegistro() {
        ArrayList<Paciente> pacientes = new ArrayList();
        try {
            pacientes = pacienteDAO.recuperarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
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

    private boolean pacienteConTratamientoActivo(Paciente paciente) {
        return paciente.getTratamiento().isActivo();
    }

    private boolean pacientePrimeraCitaAsistida(Paciente paciente) {
        return (paciente.getTratamiento().getUltimaAplicacion() != null);
    }

}
