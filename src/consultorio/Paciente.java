package consultorio;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Milka
 */
public class Paciente extends Persona{

    private ArrayList<String> medicamentosExternos; 
    private ArrayList<String> enfermedadesPrevias;
    private int dosis_ml_EDTA;
    private Tratamiento tratamiento;
    private final Date fechaDeInscripcion;
    private ArrayList<Cita> historialDeCitas;
    

    public Paciente(Persona persona, Tratamiento tratamiento, ArrayList<String> enfermedadesPrevias, 
            ArrayList<String> medicamentosExternos) {
        super(persona.getNombres(), persona.getApellidos(),persona.getEdad(), persona.getDireccion(), persona.getLocalidad(), persona.getTelefono() );
        this.tratamiento = tratamiento;
        this.enfermedadesPrevias = enfermedadesPrevias;
        this.medicamentosExternos = medicamentosExternos;
        fechaDeInscripcion = inicializarFechaDeIncripcion();
        historialDeCitas = new ArrayList();
    }

    public ArrayList<String> getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }

    public void setEnfermedadesPrevias(ArrayList<String> enfermedadesPrevias) {
        this.enfermedadesPrevias = enfermedadesPrevias;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    private Date inicializarFechaDeIncripcion(){
        return new Date();
    }

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public ArrayList<Cita> getHistorialDeCitas() {
        return historialDeCitas;
    }

    public void setHistorialDeCitas(ArrayList<Cita> historialDeCitas) {
        this.historialDeCitas = historialDeCitas;
    }
    
    public Cita getSiguienteCita(){
        Cita cita = historialDeCitas.get(historialDeCitas.size()-1);        
        return cita;
    }
    
    public void setSiguienteCita(Cita cita){
        historialDeCitas.add(cita);
    }
}
