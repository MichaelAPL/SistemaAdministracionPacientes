/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Milka
 */
public class Paciente extends Persona{

    private ArrayList<String> enfermedadesPrevias;
    private int dosisEDTA;
    private Date fechaDeInscripcion;

    public Paciente(Persona persona, int dosisEDTA, ArrayList<String> enfermedadesPrevias ) {
        this.nombres = persona.nombres;
        this.apellidos = persona.apellidos;
        this.edad = persona.edad;
        this.direccion = persona.direccion;
        this.localidad = persona.localidad;
        this.telefono = persona.telefono;
        this.dosisEDTA = dosisEDTA;
        this.enfermedadesPrevias = enfermedadesPrevias;
        fechaDeInscripcion = inicializarFechaDeIncripcion();
    }

    public ArrayList<String> getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }

    public void setEnfermedadesPrevias(ArrayList<String> enfermedadesPrevias) {
        this.enfermedadesPrevias = enfermedadesPrevias;
    }

    public int getDosisEDTA() {
        return dosisEDTA;
    }

    public void setDosisEDTA(int dosisEDTA) {
        this.dosisEDTA = dosisEDTA;
    }

    private Date inicializarFechaDeIncripcion(){
        return new Date();
    }

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }
    
}
