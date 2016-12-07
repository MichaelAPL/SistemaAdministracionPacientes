/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class InventarioUtensilios extends Insumo {
    private double existencias;

    public InventarioUtensilios(String nombre, double existencias, double costoUnitario){
        super(nombre, costoUnitario);
        this.existencias = existencias;
    }

    public double getExistencias() {
        return existencias;
    }

    public void setExistencias(double existencias) {
        this.existencias = existencias;
    }      
}
