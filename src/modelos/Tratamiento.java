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

    private Aplicacion siguienteAplicacion;
    private Aplicacion ultimaAplicacion;
    private boolean activo;
    private int dosisEDTA_ml;
    private int id;
    private int idPaciente;

    public Tratamiento(int dosisEDTA) {
        this.dosisEDTA_ml = dosisEDTA;
        this.ultimaAplicacion = null;
        this.siguienteAplicacion = new Aplicacion(1);
        this.activo = true;
    }

    public void agregarAplicacion() {
        int numSiguienteAplicacion = siguienteAplicacion.getNumAplicacion() + 1;

        ultimaAplicacion = siguienteAplicacion;
        siguienteAplicacion = new Aplicacion(numSiguienteAplicacion);
        siguienteAplicacion.setTratamientoID(id);
    }

    public int getNumeroAplicacionesRealizadas() {
        int ningunaAplicacion = 0;

        if (ultimaAplicacion == null) {
            return ningunaAplicacion;
        } else {
            return ultimaAplicacion.getNumAplicacion();
        }
    }

    public Aplicacion getSiguienteAplicacion() {
        return siguienteAplicacion;
    }

    public void setSiguienteAplicacion(Aplicacion siguienteAplicacion) {
        this.siguienteAplicacion = siguienteAplicacion;
    }

    public Aplicacion getUltimaAplicacion() {
        return ultimaAplicacion;
    }

    public void setUltimaAplicacion(Aplicacion ultimaAplicacion) {
        this.ultimaAplicacion = ultimaAplicacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getDosisEDTA_ml() {
        return dosisEDTA_ml;
    }

    public void setDosisEDTA_ml(int dosis) {
        this.dosisEDTA_ml = dosis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

}
