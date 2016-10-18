package modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Milka
 */
public class Paciente extends Persona{

    private ArrayList<String> medicamentosExternos; 
    private ArrayList<String> enfermedadesPrevias;
    private Tratamiento tratamiento;
    private final Date fechaDeInscripcion;
    private ArrayList<Cita> historialDeCitas;
    private String clave;
    
    public Paciente(Persona persona){
        super(persona.getNombres(), persona.getApellidos(),persona.getEdad(), 
                persona.getDireccion(), persona.getLocalidad(), persona.getTelefono());        
        fechaDeInscripcion = inicializarFechaDeIncripcion();
        historialDeCitas = new ArrayList();
    }
    

    public Paciente(Persona persona, Tratamiento tratamiento, ArrayList<String> enfermedadesPrevias, 
            ArrayList<String> medicamentosExternos) {
        super(persona.getNombres(), persona.getApellidos(),persona.getEdad(), 
                persona.getDireccion(), persona.getLocalidad(), persona.getTelefono());
        this.tratamiento = tratamiento;
        this.enfermedadesPrevias = enfermedadesPrevias;
        this.medicamentosExternos = medicamentosExternos;
        fechaDeInscripcion = inicializarFechaDeIncripcion();
        historialDeCitas = new ArrayList();
        clave = java.util.UUID.randomUUID().toString();
    }

    public ArrayList<String> getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }

    public void setEnfermedadesPrevias(ArrayList<String> enfermedadesPrevias) {
        this.enfermedadesPrevias = enfermedadesPrevias;
    }

    public ArrayList<String> getMedicamentosExternos() {
        return medicamentosExternos;
    }

    public void setMedicamentosExternos(ArrayList<String> medicamentosExternos) {
        this.medicamentosExternos = medicamentosExternos;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
