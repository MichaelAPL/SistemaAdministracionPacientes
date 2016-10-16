/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Paciente;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class PacienteDAO {
    private ConectorBD conectorBD = new ConectorBD();
    
    public void crearPaciente(Paciente paciente) throws SQLException{
        conectorBD.conectar();
        String campos = "Nombre, Apellido, Direccion, Localidad, Telefono, "
                +"Edad, ClvPaciente, EnfermedadesPrevias, MedicamentosExternos";
        
        String consulta = "INSERT INTO Paciente ("+campos+")"+" VALUES (?,?,?,?,?,?,?,?,?)";        
        PreparedStatement st = conectorBD.getConector().prepareStatement(consulta);
        st.setString(1, paciente.getNombres());
        st.setString(2, paciente.getApellidos());
        st.setString(3, paciente.getDireccion());
        st.setString(4, paciente.getLocalidad());
        st.setString(5, paciente.getTelefono());
        st.setString(6, String.valueOf(paciente.getEdad()));
        st.setString(7, paciente.getId());
        
        /*Se utiliza esta clase para poder meter un ArrayList a la base de datos
        convirtiendola en un Json*/
        Gson gson = new Gson();
        
        String enfermedadesPrevias = gson.toJson(paciente.getEnfermedadesPrevias());
        st.setString(8, enfermedadesPrevias);
        
        String medicamentosExternos = gson.toJson(paciente.getMedicamentosExternos());
        st.setString(9, medicamentosExternos);
        
        st.execute();
        conectorBD.desconectar();
    }
}
