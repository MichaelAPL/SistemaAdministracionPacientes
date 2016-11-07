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

    public Suero getSuero() {
        return suero;
    }

    public void setSuero(Suero suero) {
        this.suero = suero;
    }
}
