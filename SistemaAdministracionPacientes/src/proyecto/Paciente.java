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
public class Paciente {
    private String nombres2;
    private String apellidos;
    private int edad;
    private String direccion;
    private String localidad;
    private String telefono;
    private ArrayList<String> enfermedadesPrevias;
    private int dosisEDTA;
    private Date fechaDeInscripcion;

    public String getNombres() {
        return nombres2;
    }

    public void setNombres(String nombres) {
        this.nombres2 = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }
    
}
