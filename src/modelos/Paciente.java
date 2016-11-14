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
    private Date fechaDeInscripcion;
    private int id;
    
    public Paciente(Persona persona, ArrayList<String> medicamentosExternos, 
            ArrayList<String> enfermedadesPrevias, Tratamiento tratamiento){        
        super(persona.getNombres(), persona.getApellidos(), 
              persona.getDireccion(), persona.getLocalidad(), persona.getTelefono(),persona.getEdad()); 
        this.medicamentosExternos = medicamentosExternos;
        this.enfermedadesPrevias = enfermedadesPrevias;
        this.tratamiento = tratamiento;
        fechaDeInscripcion = inicializarFechaDeInscripcion(); 
    }
    
    public Paciente(Persona persona, ArrayList<String> medicamentosExternos, 
            ArrayList<String> enfermedadesPrevias, Tratamiento tratamiento, int id){        
        super(persona.getNombres(), persona.getApellidos(), 
                persona.getDireccion(), persona.getLocalidad(), persona.getTelefono(),persona.getEdad()); 
        this.medicamentosExternos = medicamentosExternos;
        this.enfermedadesPrevias = enfermedadesPrevias;
        this.tratamiento = tratamiento;
        fechaDeInscripcion = inicializarFechaDeInscripcion(); 
        this.id = id;
    }
    
    //Hay que eliminar
    public Paciente(Persona persona, Date fechaInscripcion){
        super(persona.getNombres(), persona.getApellidos(), 
                persona.getDireccion(), persona.getLocalidad(), persona.getTelefono(),persona.getEdad());        
        fechaDeInscripcion = fechaInscripcion;
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

    private Date inicializarFechaDeInscripcion(){
        return new Date();
    }

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
