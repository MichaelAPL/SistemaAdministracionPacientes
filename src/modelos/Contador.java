package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import modelos.DAOs.FacturaDAO;
import modelos.DAOs.IngresoDAO;

public class Contador {

    private static Contador contador;
    private FacturaDAO facturaDao;
    private IngresoDAO ingresoDao;

    private Contador() {
        facturaDao = new FacturaDAO();
        ingresoDao = new IngresoDAO();
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
            facturaDao.crearFactura(factura);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
    }

    public void agregarIngreso(double pagoAplicacion) {
        try {
            Fecha fechaRegistro = new Fecha();
            Ingreso ingreso = new Ingreso(fechaRegistro, pagoAplicacion);
            ingresoDao.crearIngreso(ingreso);
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }

    }

    public double calcularGanancia() {
        double ganancia = 0;
        return ganancia;
    }

    public double calcularGananciaMensual(int mes, int año) {
        double ganancia = calcularIngresoMensual(mes, año) - calcularImporteMensual(mes, año);
        return ganancia;
    }

    private double calcularImporteMensual(int mes, int año) {
        double importe = 0;
        try {
            ArrayList<Factura> facturasDelMes = facturaDao.recuperarFacturasMes(mes, año);
            for (int i = 0; i < facturasDelMes.size(); i++) {
                importe += facturasDelMes.get(i).getMonto();
            }
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
        return importe;
    }

    private double calcularIngresoMensual(int mes, int año) {
        double ingreso = 0;
        try {
            ArrayList<Ingreso> ingresosDelMes = ingresoDao.recuperarIngresosMes(mes, año);
            for (int i = 0; i < ingresosDelMes.size(); i++) {
                ingreso += ingresosDelMes.get(i).getMonto();
            }
        } catch (SQLException e) {
            MensajesDeDialogo.errorConLaBD();
        }
        return ingreso;
    }

    public void cobrarPaciente() {
        double costoAplicacion = 900;
        agregarIngreso(costoAplicacion);
    }
}
