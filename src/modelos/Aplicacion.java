package modelos;

import modelos.enums.Suero;

public class Aplicacion {

    private Fecha fecha;
    private Suero suero;
    private boolean realizada;
    private int numAplicacion;
    private int tratamientoID;

    public Aplicacion(int numAplicacion) {
        this.fecha = new Fecha();
        this.suero = setSuero();
        this.realizada = false;
        this.numAplicacion = numAplicacion;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Suero getSuero() {
        return suero;
    }
    
    private Suero setSuero() {
        if (cambiarASueroMineral()) {
            return Suero.MINERAL;
        } else {
            return Suero.QUELANTE;
        }
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public int getNumAplicacion() {
        return numAplicacion;
    }

    public void setNumAplicacion(int numAplicacion) {
        this.numAplicacion = numAplicacion;
    }

    public int getTratamientoID() {
        return tratamientoID;
    }

    public void setTratamientoID(int tratamientoID) {
        this.tratamientoID = tratamientoID;
    }

    private boolean cambiarASueroMineral() {
        int NUM_SUERO_PARA_CAMBIO = 6;
        return (numAplicacion % NUM_SUERO_PARA_CAMBIO == 0);
    }

}
