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
        //indices campos
        int INDICE_REALIZADA = 1;
        int INDICE_FECHA = 2;
        int INDICE_NUM_APLICACION = 3;
        int INDICE_TRATAMIENTO_ID = 4;
        
        conectorBD.conectar();

        String campos = "Realizada, Fecha, Num_Aplicacion, Tratamiento_ID";
        String consulta = "INSERT INTO Aplicacion (" + campos + ") VALUES (?,?,?,?)";

        PreparedStatement declaracion = conectorBD.consulta(consulta);

        declaracion.setBoolean(INDICE_REALIZADA, aplicacion.isRealizada());

        java.sql.Date fechaAplicacion = new java.sql.Date(aplicacion.getFecha().getTime());
        declaracion.setDate(INDICE_FECHA, fechaAplicacion);
        declaracion.setInt(INDICE_NUM_APLICACION, aplicacion.getNumAplicacion());
        declaracion.setInt(INDICE_TRATAMIENTO_ID, aplicacion.getTratamiento_id());

        declaracion.execute();

        conectorBD.desconectar();
    }

    public void actualizar(Aplicacion aplicacion) throws SQLException {
        //indices campos
        int INDICE_REALIZADA = 1;
        int INDICE_FECHA = 2;
        int INDICE_CLAUSULA = 3;
        
        conectorBD.conectar();

        String consulta = "UPDATE Aplicacion SET Realizada = ?, Fecha = ? WHERE "
                + "Tratamiento_ID = ?";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);

        declaracion.setBoolean(INDICE_REALIZADA, aplicacion.isRealizada());

        java.sql.Date fechaDeAplicacion = new java.sql.Date(aplicacion.getFecha().getTime());
        declaracion.setDate(INDICE_FECHA, fechaDeAplicacion);
        declaracion.setInt(INDICE_CLAUSULA, aplicacion.getTratamiento_id());

        declaracion.execute();
        conectorBD.desconectar();
    }

    public Aplicacion obtenerUltimaAplicacion(int tratamientoID, int numUltimaAplicacion) throws SQLException {
        conectorBD.conectar();

        String consulta = "select * from Aplicacion WHERE Num_Aplicacion = " + numUltimaAplicacion;
        PreparedStatement declaracion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracion.executeQuery();

        Aplicacion ultimaAplicacion = null;
        ultimaAplicacion = new Aplicacion(resultado.getInt("Num_Aplicacion"));
        ultimaAplicacion.setFecha(new Fecha(resultado.getDate("Fecha")));
        ultimaAplicacion.setRealizada(true);
        ultimaAplicacion.setTratamiento_id(resultado.getInt("Tratamiento_ID"));

        conectorBD.desconectar();
        return ultimaAplicacion;
    }

    public Aplicacion obtenerSiguienteAplicacion(int tratamientoID) throws SQLException {
        conectorBD.conectar();
        String consulta = "select * from Aplicacion where Tratamiento_ID = "+tratamientoID
                + " and Realizada = 0";

        PreparedStatement declaracion = conectorBD.consulta(consulta);

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
