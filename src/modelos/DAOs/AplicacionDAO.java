/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Aplicacion;
import modelos.Fecha;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class AplicacionDAO {

    private ConectorBD conectorBD;

    public AplicacionDAO() {
        this.conectorBD = new ConectorBD();
    }

    public void crearAplicacion(Aplicacion aplicacion) throws SQLException {
        conectorBD.conectar();

        String campos = "Realizada, Fecha, Num_Aplicacion, Tratamiento_ID";
        String consulta = "INSERT INTO Aplicacion (" + campos + ") VALUES (?,?,?,?)";

        PreparedStatement declaracion = conectorBD.consulta(consulta);

        declaracion.setBoolean(1, aplicacion.isRealizada());

        java.sql.Date fechaAplicacion = new java.sql.Date(aplicacion.getFecha().getTime());
        declaracion.setDate(2, fechaAplicacion);
        declaracion.setInt(3, aplicacion.getNumAplicacion());
        declaracion.setInt(4, aplicacion.getTratamiento_id());

        declaracion.execute();

        conectorBD.desconectar();
    }

    public void actualizar(Aplicacion aplicacion) throws SQLException {
        conectorBD.conectar();

        String consulta = "UPDATE Aplicacion SET Realizada = ?, Fecha = ? WHERE "
                + "Tratamiento_ID = ?";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);

        declaracion.setBoolean(1, aplicacion.isRealizada());

        java.sql.Date fechaDeAplicacion = new java.sql.Date(aplicacion.getFecha().getTime());
        declaracion.setDate(2, fechaDeAplicacion);
        declaracion.setInt(3, aplicacion.getTratamiento_id());

        declaracion.execute();
        conectorBD.desconectar();
    }

    public Aplicacion getUltimaAplicacion(int tratamiento_ID, int siguienteAplicacion) throws SQLException {
        conectorBD.conectar();

        String consulta = "select * from Aplicacion WHERE Num_Aplicacion = ?";
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        declaracion.setInt(1, siguienteAplicacion);

        ResultSet resultado = declaracion.executeQuery();

        Aplicacion ultimaAplicacion = null;
        ultimaAplicacion = new Aplicacion(resultado.getInt("Num_Aplicacion"));
        ultimaAplicacion.setFecha(new Fecha(resultado.getDate("Fecha")));
        ultimaAplicacion.setRealizada(true);
        ultimaAplicacion.setTratamiento_id(resultado.getInt("Tratamiento_ID"));

        conectorBD.desconectar();
        return ultimaAplicacion;
    }

    public Aplicacion getSiguienteAplicacion(int tratamiento_ID) throws SQLException {
        conectorBD.conectar();

        String consulta = "select * from Aplicacion where Tratamiento_ID = ? and Realizada = '0'";

        PreparedStatement declaracion = conectorBD.consulta(consulta);
        declaracion.setInt(1, tratamiento_ID);

        ResultSet resultado = declaracion.executeQuery();

        Aplicacion sigAplicacion = null;

        int numAplicacion = resultado.getInt("Num_Aplicacion");
        sigAplicacion = new Aplicacion(numAplicacion);
        sigAplicacion.setRealizada(resultado.getBoolean("Realizada"));
        sigAplicacion.setTratamiento_id(resultado.getInt("Tratamiento_ID"));
        sigAplicacion.setFecha(new Fecha(resultado.getDate("Fecha")));

        conectorBD.desconectar();
        return sigAplicacion;
    }
}
