/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import java.util.Date;

/**
 *
 * @author Milka
 */
class Cita {

    private Date fechaDeRealizacion;
    private Date fechaProgramada;
    private boolean realizada;
    private int numeroDeCita;
    private Suero tipo;

    public Cita(int numeroDeCita, Suero tipo) {
        this.numeroDeCita = numeroDeCita;
        this.fechaProgramada = new Date();
        this.fechaDeRealizacion = null;
        this.tipo = tipo;
        this.realizada = false;
    }

    public Date getFechaDeRealizacion() {
        if (isRealizada()) {
            fechaDeRealizacion = getFechaProgramada();
        }
        return fechaDeRealizacion;
    }

    protected void setFechaDeRealizacion(Date fechaDeRealizacion) {
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public Date getFechaProgramada() {
        if (!isRealizada()) {
            fechaProgramada = new Date();
        }
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public int getNúmeroDeCita() {
        return numeroDeCita;
    }

    public void setNumeroDeCita(int numeroDeCita) {
        this.numeroDeCita = numeroDeCita;
    }

    public Suero getTipo() {
        return tipo;
    }

    public void setTipo(Suero tipo) {
        this.tipo = tipo;
    }

}
