/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Date;

/**
 *
 * @author Milka
 */
class Cita {
    
    private Date fechaDeRealizacion;
    private int númeroDeCita;
    private Tratamiento tipo;

    public Date getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }

    protected void setFechaDeRealizacion() {
        this.fechaDeRealizacion = new Date();
    }

    public int getNúmeroDeCita() {
        return númeroDeCita;
    }

    public void setNúmeroDeCita(int númeroDeCita) {
        this.númeroDeCita = númeroDeCita;
    }

    public Tratamiento getTipo() {
        return tipo;
    }

    public void setTipo(Tratamiento tipo) {
        this.tipo = tipo;
    }
    
    
    
}
