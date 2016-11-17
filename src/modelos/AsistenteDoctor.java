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

/**
 *
 * @author Milka
 */
public class AsistenteDoctor {

    private ArrayList<Paciente> pacientes;
    private ArrayList<Paciente> pacientesConCitaHoy;
    private PacienteDAO pacienteDAO;
    private static AsistenteDoctor asistente;
    
    
    private AsistenteDoctor() {
        pacienteDAO = new PacienteDAO();
        actualizarListaPacientes();
    }
    
    public static AsistenteDoctor obtenerUnicoAsistenteDoctor(){
        if(asistente == null){
            asistente = new AsistenteDoctor();
        }
        return asistente;
    }
    
    private void actualizarListaPacientes(){
        try {
            pacientes = pacienteDAO.recuperarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void mandarAVentanaAPacientesConCitas() {
        pacientesConCitaHoy = generarListaDePacientesConCita();
        VentanaPaseLista.obtenerUnicaVentana().mostrarPacientesConCita(pacientesConCitaHoy);
    }

    public void ponerAsistenciaAlPaciente(int numeroDePacienteEnLaLista) {
        Paciente paciente = pacientesConCitaHoy.get(numeroDePacienteEnLaLista);
        paciente.getTratamiento().getSiguienteAplicacion().setRealizada(true);
        paciente.getTratamiento().getSiguienteAplicacion().setFecha(new Date());

        crearNuevaCitaAlPaciente(paciente);
    }

    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();
        paciente.getTratamiento().getSiguienteAplicacion().setTratamiento_id
        (paciente.getTratamiento().getUltimaAplicacion().getTratamiento_id());
        try {
            pacienteDAO.actualizarAplicaciones(paciente);
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void buscarPaciente(String nombrePaciente){
        try {
            VentanaBusqueda.obtenerUnicaVentanaBusqueda().mostrarPacientes(
                    pacienteDAO.getPacientesPorNombre(nombrePaciente));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void buscarPacientePorId(String id){
        try {
            VentanaDatosPaciente.obtenerUnicaVentanaDatosPaciente()
                    .mostrarDatosPaciente(pacienteDAO.getPacientePorID(Integer.valueOf(id)));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    
    public void mandarAVentanaDatosPaciente(String id){
        try {
            VentanaDatosPaciente.obtenerUnicaVentanaDatosPaciente().
                    mostrarDatosPaciente(pacienteDAO.getPacientePorID(Integer.valueOf(id)));
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarPaciente(Paciente paciente){
        try {
            pacienteDAO.actualizar(paciente);
        } catch (SQLException ex) {
            Logger.getLogger(AsistenteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
