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
    private int numeroDeCita;
    private Suero tipo;

    public Date getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }

    protected void setFechaDeRealizacion() {
        this.fechaDeRealizacion = new Date();
    }

    public int getNúmeroDeCita() {
        return numeroDeCita;
    }

    public void setNúmeroDeCita() {
        numeroDeCita++;
    }

    public Suero getTipo() {
        return tipo;
    }    

    public void setTipo(Suero tipo) {
        this.tipo = tipo;
    }
    
    
}
