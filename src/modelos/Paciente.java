package modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Milka
 */
public class Paciente extends Persona {

    private ArrayList<String> medicamentosExternos;
    private ArrayList<String> enfermedadesPrevias;
    private Tratamiento tratamiento;
    private Fecha fechaDeInscripcion;
    private int id;

    public Paciente(Persona persona, ArrayList<String> medicamentosExternos,
            ArrayList<String> enfermedadesPrevias, Tratamiento tratamiento) {
        super(persona.getNombres(), persona.getApellidos(),
                persona.getDireccion(), persona.getLocalidad(), persona.getTelefono(), persona.getEdad());
        this.medicamentosExternos = medicamentosExternos;
        this.enfermedadesPrevias = enfermedadesPrevias;
        this.tratamiento = tratamiento;
        fechaDeInscripcion = new Fecha();
    }

    public Paciente(Persona persona, ArrayList<String> medicamentosExternos,
            ArrayList<String> enfermedadesPrevias, Tratamiento tratamiento,
            Date fechaInscripcion, int id) {
        super(persona.getNombres(), persona.getApellidos(),
                persona.getDireccion(), persona.getLocalidad(), persona.getTelefono(), persona.getEdad());
        this.medicamentosExternos = medicamentosExternos;
        this.enfermedadesPrevias = enfermedadesPrevias;
        this.tratamiento = tratamiento;
        this.fechaDeInscripcion = new Fecha(fechaInscripcion);
        this.id = id;
    }

    public ArrayList<String> getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }

    public void setEnfermedadesPrevias(ArrayList<String> enfermedadesPrevias) {
        this.enfermedadesPrevias = enfermedadesPrevias;
    }

    public void insertarEnfermedad(String enfermedadNueva) {
        this.enfermedadesPrevias.add(enfermedadNueva);
    }
    
    public void eliminarEnfermedad(String enfermedad){
        this.enfermedadesPrevias.remove(enfermedad);
    }

    public ArrayList<String> getMedicamentosExternos() {
        return medicamentosExternos;
    }

    public void setMedicamentosExternos(ArrayList<String> medicamentosExternos) {
        this.medicamentosExternos = medicamentosExternos;
    }

    public void insertarMedicamento(String medicamentoNuevo) {
        this.medicamentosExternos.add(medicamentoNuevo);
    }
    
    public void eliminarMedicamento(String medicamento){
        this.medicamentosExternos.remove(medicamento);
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Fecha getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
