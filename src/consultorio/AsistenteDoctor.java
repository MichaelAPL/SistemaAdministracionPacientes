package consultorio;

import java.util.ArrayList;
import java.util.Date;
import ventanillas.VentanillaPaseDeLista;

/**
 *
 * @author Milka
 */
public class AsistenteDoctor {

    private VentanillaPaseDeLista ventanillaPaseLista;
    private ArrayList<Paciente> bancoDePacientes;
    private ArrayList<Paciente> pacientesConCitaHoy;
    
    public AsistenteDoctor(ArrayList<Paciente> pacientes){
        this.bancoDePacientes = pacientes;
        this.pacientesConCitaHoy = generarListaDePacientesConCitaHoy();
    }

    public ArrayList<Paciente> generarListaDePacientesConCitaHoy() {
        ArrayList<Paciente> listaDePacientesConCitaHoy = new ArrayList();
        Date fechaHoy = new Date();
        for (Paciente paciente : bancoDePacientes) {
            if (paciente.getSiguienteCita().getFechaProgramada().equals(fechaHoy)) {
                listaDePacientesConCitaHoy.add(paciente);
            }
        }
        return listaDePacientesConCitaHoy;
    }

    public void mandarAVentanillaAPacientesConCitas() {
        ventanillaPaseLista.crearListaDeCitasHoy(pacientesConCitaHoy);
    }

    public void ponerAsistenciaAlPaciente(int numeroDePacienteEnLaLista) {
        Paciente paciente = pacientesConCitaHoy.remove(numeroDePacienteEnLaLista);
        paciente.getSiguienteCita().setRealizada(true);
        
        crearNuevaCitaAlPaciente(paciente);
    }
    
    public void crearNuevaCitaAlPaciente(Paciente paciente){
        Cita cita = new Cita(paciente.getSiguienteCita().getNumeroDeCita()+1);
        paciente.setSiguienteCita(cita);
    }
    
    public Paciente buscarPaciente(String nombre){
        Paciente paciente = null;
        for (int i = 0; i < bancoDePacientes.size(); i++) {
            if (bancoDePacientes.get(i).getNombres().equals(nombre)) {
                paciente = bancoDePacientes.get(i);
            }
        }
        return paciente;
    }

}
