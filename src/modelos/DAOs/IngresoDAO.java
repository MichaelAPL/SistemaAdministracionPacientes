/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Fecha;
import modelos.Ingreso;
import modelos.IntervaloFecha;
import modelos.database.ConectorBD;

/**
 *
 * @author Milka
 */
public class IngresoDAO {
    private ConectorBD conectorBD;
    
    public IngresoDAO() {
        this.conectorBD = new ConectorBD();
    }

    public void crearIngreso(Ingreso ingreso) throws SQLException {
        conectorBD.conectar();

        String campos = "FolioIngreso, Fecha, Monto";

        String consulta = "INSERT INTO Ingresos (" + campos + ")" + " VALUES (?,?,?,?)";

        PreparedStatement declaracion = conectorBD.consulta(consulta);

        java.sql.Date fechaRegistro = new java.sql.Date(ingreso.getFecha().getTime());
        declaracion.setDate(2, fechaRegistro);
        declaracion.setDouble(3, ingreso.getMonto());

        declaracion.execute();

        conectorBD.desconectar();
    }

        public ArrayList<Ingreso> recuperarIngresosMes(int mes, int año) throws SQLException {
        this.conectorBD.conectar();

        String consulta = "SELECT * FROM Facturas WHERE fechaRegistro BETWEEN ? AND ?";
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        IntervaloFecha intervalo = new IntervaloFecha(mes, año);
        java.sql.Date inferior = new java.sql.Date(intervalo.getInferior().getTime());
        java.sql.Date superior = new java.sql.Date(intervalo.getSuperior().getTime());
        
        declaracionDeRecuperacion.setDate(1, inferior);
        declaracionDeRecuperacion.setDate(2, superior);
        
        ResultSet resultado = declaracionDeRecuperacion.executeQuery();

        ArrayList<Ingreso> ingresos = new ArrayList();

        while (resultado.next()) {
            Ingreso ingreso = new Ingreso(resultado.getInt("FolioFactura"), new Fecha (resultado.getDate("FechaRegistro")),
                    resultado.getDouble("Importe"));
            
            ingresos.add(ingreso);
        }

        this.conectorBD.desconectar();
        return ingresos;
    }
    
        public ArrayList<Ingreso> recuperarFacturas(int mes, int año) throws SQLException {
        this.conectorBD.conectar();

        String consulta = "SELECT * FROM Facturas";
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracionDeRecuperacion.executeQuery();
        
        ArrayList<Ingreso> ingresos = new ArrayList();

        while (resultado.next()) {
            Ingreso ingreso = new Ingreso(resultado.getInt("FolioFactura"), new Fecha (resultado.getDate("FechaRegistro")),
                    resultado.getDouble("Importe"));
            
            ingresos.add(ingreso);
        }

        this.conectorBD.desconectar();
        return ingresos;
    }
}
