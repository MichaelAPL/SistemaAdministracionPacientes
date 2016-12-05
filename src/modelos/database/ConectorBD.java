package modelos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author miguelangel
 */
public class ConectorBD {
    
    private Connection conexion;
    
    public void conectar() throws SQLException{
        conexion = DriverManager.getConnection("jdbc:sqlite:BaseDatosConsultorio.db");
    }
    
    public PreparedStatement consulta(String consulta) throws SQLException{
        return this.conexion.prepareStatement(consulta);
    }
    
    public void desconectar() throws SQLException{
        conexion.close();
    }
    
   
}
