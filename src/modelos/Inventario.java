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
public class Inventario {
    private String nombreProducto;
    private int cantidadExistente;
    private double costoUnitario;
    private double costoTotal;

    public Inventario(String nombreProducto, int cantidad, double costoUnitario) {
        this.nombreProducto = nombreProducto;
        this.cantidadExistente = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoTotal = calcularCostoTotal();
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the cantidadExistente
     */
    public int getCantidadExistente() {
        return cantidadExistente;
    }

    /**
     * @param cantidadExistente the cantidadExistente to set
     */
    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    /**
     * @return the costoUnitario
     */
    public double getCostoUnitario() {
        return costoUnitario;
    }

    /**
     * @param costoUnitario the costoUnitario to set
     */
    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    /**
     * @return the costoTotal
     */
    public double getCostoTotal() {
        return costoTotal;
    }

    /**
     * @param costoTotal the costoTotal to set
     */
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    
    private double calcularCostoTotal(){
        return cantidadExistente*costoUnitario;
    }
}
