package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.DAOs.PacienteDAO;
import vistas.VentanaBusqueda;
import vistas.VentanaDatosPaciente;
import vistas.VentanaPaseLista;

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

    public void buscarPacientePorId(String id) {
        try {
            VentanaDatosPaciente.obtenerUnicaVentanaDatosPaciente()
                    .mostrarDatosPaciente(pacienteDAO.getPacientePorID(Integer.valueOf(id)));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void buscarPacientePorNombre(String nombrePaciente) {
        try {
            VentanaBusqueda.obtenerUnicaVentanaBusqueda().mostrarPacientes(
                    pacienteDAO.getPacientesPorNombre(nombrePaciente));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void mandarAVentanaAPacientesConCitas() {
        VentanaPaseLista.obtenerUnicaVentana().mostrarPacientesConCita(generarListaDePacientesConCita());
    }

    public void mandarAVentanaDatosPaciente(String pacienteID) {
        try {
            VentanaDatosPaciente.obtenerUnicaVentanaDatosPaciente().
                    mostrarDatosPaciente(pacienteDAO.getPacientePorID(Integer.valueOf(pacienteID)));
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ponerAsistenciaAlPaciente(String pacienteID) {
        Paciente paciente;
        try {
            paciente = pacienteDAO.getPacientePorID(Integer.valueOf(pacienteID));
            paciente.getTratamiento().getSiguienteAplicacion().setRealizada(true);
            paciente.getTratamiento().getSiguienteAplicacion().setFecha(new Date());

            crearNuevaCitaAlPaciente(paciente);
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();
        paciente.getTratamiento().getSiguienteAplicacion().setTratamiento_id(paciente.getTratamiento().getUltimaAplicacion().getTratamiento_id());
        try {
            pacienteDAO.actualizarAplicaciones(paciente);
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private ArrayList<Paciente> generarListaDePacientesConCita() {
        ArrayList<Paciente> listaPacientesConCita = new ArrayList();
        ArrayList<Paciente> pacientes = new ArrayList();
        try {
            pacientes = pacienteDAO.recuperarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Paciente paciente : pacientes) {
            if (!pacienteAsistidoHoy(paciente) && pacienteConTratamientoActivo(paciente)) {
                listaPacientesConCita.add(paciente);
            }
        }
        return listaPacientesConCita;
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
