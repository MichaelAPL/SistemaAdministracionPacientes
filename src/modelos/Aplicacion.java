/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;
import modelos.enums.Suero;

/**
 *
 * @author miguelangel
 */
public class Aplicacion {

    private boolean realizada;
    private Date fecha;
    private Suero suero;
    private int numAplicacion;
    private int tratamiento_id;


    public Aplicacion(int numAplicacion) {
        this.realizada = false;
        this.fecha = null;
        this.numAplicacion = numAplicacion;
        this.suero = setSuero();
    }

    public int getNumAplicacion() {
        return numAplicacion;
    }

    public void setNumAplicacion(int numAplicacion) {
        this.numAplicacion = numAplicacion;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTratamiento_id() {
        return tratamiento_id;
    }

    public void setTratamiento_id(int tratamiento_id) {
        this.tratamiento_id = tratamiento_id;
    }
    
    public Suero getSuero() {
        return suero;
    }

    public void setSuero(Suero suero) {
        this.suero = suero;
    }

    private Suero setSuero() {

        if (cambiarASueroMineral()) {
            return Suero.MINERAL;
        } else {
            return Suero.QUELANTE;
        }
    }
    
    private boolean cambiarASueroMineral(){
        int  NUM_SUERO_PARA_CAMBIO = 6;
        return (numAplicacion % NUM_SUERO_PARA_CAMBIO == 0);
    }
    
    
}
