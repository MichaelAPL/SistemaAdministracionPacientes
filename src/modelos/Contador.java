/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.SQLException;
import modelos.DAOs.FacturaDAO;

/**
 *
 * @author Milka
 */
public class Contador {

    private static Contador contador;
    private FacturaDAO facturasDao;

    private Contador() {
        facturasDao = new FacturaDAO();
    }

    public static Contador llamarContador() {
        if (contador == null) {
            contador = new Contador();
        }
        return contador;
    }

    public void agregarImporte(double pagoInsumos, String descripcion) {
        try {
            Fecha fechaRegistro = new Fecha();
            Factura factura = new Factura(fechaRegistro, pagoInsumos, descripcion);
            facturasDao.crearFactura(factura);
        } catch (SQLException e) {

        }
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
