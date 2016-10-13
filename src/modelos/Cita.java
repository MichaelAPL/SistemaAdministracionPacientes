/*
 *
 */
package modelos;

import java.util.Date;

public class Cita {
    
    private Date fechaDeRealizacion;
    private Date fechaProgramada;
    private int numeroDeCita;
    private boolean realizada;

    public Cita(int numeroDeCita) {
        realizada = false;
        fechaDeRealizacion = null;
        this.numeroDeCita = numeroDeCita;
    }

    
    public Date getFechaDeRealizacion() {
        if(isRealizada()){
           fechaDeRealizacion = getFechaProgramada(); 
        }
        return fechaDeRealizacion;
    }

    public void setFechaDeRealizacion(Date fechaDeRealizacion) {
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public Date getFechaProgramada() {
        if(!isRealizada()){
            fechaProgramada = new Date();
        }
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public int getNumeroDeCita() {
        return numeroDeCita;
    }

    public void setNumeroDeCita(int numeroDeCita) {
        this.numeroDeCita = numeroDeCita;
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

    public void setNúmeroDeCita() {
        numeroDeCita++;
    }    
}