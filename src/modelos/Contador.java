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
public class Contador {

    private static Contador contador;

    private Contador() {

    }

    public static Contador llamarContador() {
        if (contador == null) {
            contador = new Contador();
        }
        return contador;
    }

    public void agregarImporte(double pagoInsumos) {
        Fecha fechaPago = new Fecha();
        
    }

    public void agregarIngreso(double pagoAplicación) {
        Fecha fechapago = new Fecha();
        
    }

    public double calcularGanancia() {
        double ganancia = 0;
        return ganancia;
    }

    public double calcularGananciaMensual() {
        double ganancia = 0;
        return ganancia;
    }
}
