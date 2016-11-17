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
public class InventarioProducto extends Producto{
    private int existencias;

    public InventarioProducto(String nombre, int existencias) {
        super(nombre);
        this.existencias = existencias;
    }
    
    public InventarioProducto(int id, String nombre, int existencias){
        super(id, nombre);
        this.existencias = existencias;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
}
