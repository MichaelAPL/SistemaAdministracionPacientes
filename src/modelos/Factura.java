/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Milka
 */
public class Factura {
    private int folio;
    private Fecha fecha;
    private double monto;
    private String descripcion;

    public Factura(Fecha fecha, double monto, String descripcion) {
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Factura(int folio, Fecha fecha, double monto, String descripcion) {
        this.folio = folio;
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public int getFolio() {
        return folio;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
