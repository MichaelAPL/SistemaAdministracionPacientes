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
public class Producto {
    private int claveProducto;
    private String nombreProducto;
    private double costoProducto;

    public Producto(int claveProducto, String nombreProducto, double costoProducto) {
        this.claveProducto = claveProducto;
        this.nombreProducto = nombreProducto;
        this.costoProducto = costoProducto;
    }

    public int getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(int claveProducto) {
        this.claveProducto = claveProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(double costoProducto) {
        this.costoProducto = costoProducto;
    }    
}
