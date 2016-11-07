/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author miguelangel
 */
public class Tratamiento {

    private String clavePaciente;
    private Aplicacion ultimaAplicacion;
    private Aplicacion siguienteAplicacion;
    private final int dosis_EDTA_ml;
    private boolean activo;

    public Tratamiento(String clavePaciente, int dosisEDTA) {
        this.clavePaciente = clavePaciente;
        this.dosis_EDTA_ml = dosisEDTA;
        this.ultimaAplicacion = null;
        this.siguienteAplicacion = new Aplicacion(0);
        this.activo = true;
    }

    public Tratamiento(int dosisEDTA) {
        this.dosis_EDTA_ml = dosisEDTA;
        this.ultimaAplicacion = null;
        this.siguienteAplicacion = new Aplicacion(0);
        this.activo = true;
    }

    public String getClavePaciente() {
        return clavePaciente;
    }

    public void setClavePaciente(String clavePaciente) {
        this.clavePaciente = clavePaciente;
    }

    public int getDosisEDTA() {
        return this.dosis_EDTA_ml;
    }

    public void agregarAplicacion() {
        int numSiguienteAplicacion = siguienteAplicacion.getNumAplicacion() + 1;
        
        ultimaAplicacion = siguienteAplicacion;
        siguienteAplicacion = new Aplicacion(numSiguienteAplicacion);
    }

    public int getNumeroAplicacionesRealizadas() {
        int ningunaAplicacion = 0;

        if (ultimaAplicacion == null) {
            return ningunaAplicacion;
        } else {
            return ultimaAplicacion.getNumAplicacion();
        }
    }

    public Aplicacion getUltimaAplicacion() {
        return ultimaAplicacion;
    }

    public Aplicacion getSiguienteAplicacion() {
        return siguienteAplicacion;
    }

    public int getDosis_EDTA_ml() {
        return dosis_EDTA_ml;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
