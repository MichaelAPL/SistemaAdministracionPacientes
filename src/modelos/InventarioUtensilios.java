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
    private int existencias;

    public InventarioUtensilios(String nombre, int existencias) {
        super(nombre);
        this.existencias = existencias;
    }
    
    public InventarioUtensilios(String nombre, int existencias, double costoUnitario){
        super(nombre, costoUnitario);
        this.existencias = existencias;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }      
}
