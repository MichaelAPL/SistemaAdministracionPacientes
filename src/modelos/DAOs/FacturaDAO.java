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
import modelos.Factura;
import modelos.Fecha;
import modelos.IntervaloFecha;
import modelos.database.ConectorBD;

/**
 *
 * @author Milka
 */
public class FacturaDAO {
    
    private ConectorBD conectorBD;
    
    public FacturaDAO() {
        this.conectorBD = new ConectorBD();
    }

    public void crearFactura(Factura factura) throws SQLException {
        conectorBD.conectar();

        String campos = "FolioFactura, FechaRegistro, Importe, Descripcion";

        String consulta = "INSERT INTO Facturas (" + campos + ")" + " VALUES (?,?,?,?)";

        PreparedStatement declaracion = conectorBD.consulta(consulta);

        java.sql.Date fechaRegistro = new java.sql.Date(factura.getFecha().getTime());
        declaracion.setDate(2, fechaRegistro);
        declaracion.setDouble(3, factura.getMonto());
        declaracion.setString(4, factura.getDescripcion());

        declaracion.execute();

        conectorBD.desconectar();
    }

    public ArrayList<Factura> recuperarFacturasMes(int mes, int año) throws SQLException {
        this.conectorBD.conectar();

        String consulta = "SELECT * FROM Facturas WHERE fechaRegistro BETWEEN ? AND ?";
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        IntervaloFecha intervalo = new IntervaloFecha(mes, año);
        java.sql.Date inferior = new java.sql.Date(intervalo.getInferior().getTime());
        java.sql.Date superior = new java.sql.Date(intervalo.getSuperior().getTime());
        System.out.println(inferior);
        System.out.println(superior);
        
        declaracionDeRecuperacion.setDate(1, inferior);
        declaracionDeRecuperacion.setDate(2, superior);
        
        ResultSet resultado = declaracionDeRecuperacion.executeQuery();

        ArrayList<Factura> facturas = new ArrayList();

        while (resultado.next()) {
            Factura factura = new Factura(resultado.getInt("FolioFactura"), new Fecha (resultado.getDate("FechaRegistro")),
                    resultado.getDouble("Importe"), resultado.getString("Descripcion"));
            
            facturas.add(factura);
        }

        this.conectorBD.desconectar();
        return facturas;
    }
    
        public ArrayList<Factura> recuperarFacturas() throws SQLException {
        this.conectorBD.conectar();

        String consulta = "SELECT * FROM Facturas";
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracionDeRecuperacion.executeQuery();
        
        ArrayList<Factura> facturas = new ArrayList();

        while (resultado.next()) {
            Factura factura = new Factura(resultado.getInt("FolioFactura"), new Fecha (resultado.getDate("FechaRegistro")),
                    resultado.getDouble("Importe"), resultado.getString("Descripcion"));
            
            facturas.add(factura);
        }

        this.conectorBD.desconectar();
        return facturas;
    }
}
