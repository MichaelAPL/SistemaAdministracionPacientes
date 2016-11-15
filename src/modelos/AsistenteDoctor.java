package modelos;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.DAOs.PacienteDAO;
import vistas.VentanaBusqueda;
import vistas.VentanaPaseLista;

/**
 *
 * @author Milka
 */
public class AsistenteDoctor {

    private VentanaPaseLista ventanillaPaseLista;
    private VentanaBusqueda ventanaBusqueda;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Paciente> pacientesConCitaHoy;
    private PacienteDAO pacienteDAO;

    public AsistenteDoctor(ArrayList<Paciente> pacientes, VentanaPaseLista ventanillaPaseLista) {
        pacienteDAO = new PacienteDAO();
        actualizarListaPacientes();
        this.pacientesConCitaHoy = generarListaDePacientesConCita();
        this.ventanillaPaseLista = ventanillaPaseLista;
        
    }
    
    public void setVentanaBusqueda(VentanaBusqueda ventanaBusqueda){
        this.ventanaBusqueda  = ventanaBusqueda;
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

    public void mandarAVentanillaAPacientesConCitas() {
        pacientesConCitaHoy = generarListaDePacientesConCita();
        ventanillaPaseLista.mostrarPacientesConCita(pacientesConCitaHoy);
    }

    public void ponerAsistenciaAlPaciente(int numeroDePacienteEnLaLista) {
        Paciente paciente = pacientesConCitaHoy.get(numeroDePacienteEnLaLista);
        paciente.getTratamiento().getSiguienteAplicacion().setRealizada(true);
        paciente.getTratamiento().getSiguienteAplicacion().setFecha(new Date());

        crearNuevaCitaAlPaciente(paciente);
    }

    private void crearNuevaCitaAlPaciente(Paciente paciente) {
        paciente.getTratamiento().agregarAplicacion();

    }
    
    public void buscarPaciente(String nombrePaciente){
        try {
            ventanaBusqueda.mostrarPacientes(
                    pacienteDAO.getPacientesPorNombre(nombrePaciente));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
