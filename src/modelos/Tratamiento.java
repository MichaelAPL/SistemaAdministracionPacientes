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
    
    private Aplicacion ultimaAplicacion;
    private Aplicacion siguienteAplicacion;
    private int dosis_EDTA_ml;
    private boolean activo;
    private int id;
    private int id_Paciente;

    public Tratamiento(int dosisEDTA) {
        this.dosis_EDTA_ml = dosisEDTA;
        this.ultimaAplicacion = null;
        this.siguienteAplicacion = new Aplicacion(1);
        this.activo = true;
    }

    public void agregarAplicacion() {
        int numSiguienteAplicacion = siguienteAplicacion.getNumAplicacion() + 1;
        
        ultimaAplicacion = siguienteAplicacion;
        siguienteAplicacion = new Aplicacion(numSiguienteAplicacion);
        siguienteAplicacion.setTratamiento_id(id);
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

    public void setUltimaAplicacion(Aplicacion ultimaAplicacion) {
        this.ultimaAplicacion = ultimaAplicacion;
    }

    public void setSiguienteAplicacion(Aplicacion siguienteAplicacion) {
        this.siguienteAplicacion = siguienteAplicacion;
    }

    public int getDosis_EDTA_ml() {
        return dosis_EDTA_ml;
    }

    public void setDosis_EDTA_ml(int dosis){
        this.dosis_EDTA_ml = dosis;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }
    
}
