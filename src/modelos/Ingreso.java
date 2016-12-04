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
public class Ingreso {
    private int folio;
    private Fecha fecha;
    private double monto;

    public Ingreso(Fecha fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    public Ingreso(int folio, Fecha fecha, double monto) {
        this.folio = folio;
        this.fecha = fecha;
        this.monto = monto;
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
}
