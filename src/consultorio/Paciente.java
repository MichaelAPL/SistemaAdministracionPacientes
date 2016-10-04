/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Milka
 */
public class Paciente extends Persona{

    private ArrayList<String> enfermedadesPrevias;
    private int dosis_ml_EDTA;
    private final Date fechaDeInscripcion;
    private ArrayList<Cita> historialDeCitas;
    

    public Paciente(Persona persona, int dosis_ml_EDTA, ArrayList<String> enfermedadesPrevias ) {
        super(persona.getNombres(), persona.getApellidos(),persona.getEdad(), persona.getDireccion(), persona.getLocalidad(), persona.getTelefono() );
        this.dosis_ml_EDTA = dosis_ml_EDTA;
        this.enfermedadesPrevias = enfermedadesPrevias;
        fechaDeInscripcion = inicializarFechaDeIncripcion();
        historialDeCitas = new ArrayList();
    }

    public ArrayList<String> getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }

    public void setEnfermedadesPrevias(ArrayList<String> enfermedadesPrevias) {
        this.enfermedadesPrevias = enfermedadesPrevias;
    }

    public int getDosis_ml_EDTA() {
        return dosis_ml_EDTA;
    }

    public void set_ml_DosisEDTA(int dosisEDTA) {
        this.dosis_ml_EDTA = dosisEDTA;
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
    
    
}
