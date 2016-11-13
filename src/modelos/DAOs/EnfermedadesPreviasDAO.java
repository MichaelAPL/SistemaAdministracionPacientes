/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Paciente;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class EnfermedadesPreviasDAO {
    private ConectorBD conectorBD;
    
    public EnfermedadesPreviasDAO(){
        this.conectorBD = new ConectorBD();
    }
        
    public void crearEnfermedadesPrevias(Paciente paciente) throws SQLException{
        conectorBD.conectar();
        
        String camposEnfermedades = "Paciente_ID, NumEnfer, NombreEnfer";
        String consulta = "INSERT INTO EnfermedadesPrevias (" + camposEnfermedades + ")" +
                " VALUES (?, ?, ?)";
        
        for (int i = 0; i < paciente.getEnfermedadesPrevias().size(); i++) {
            PreparedStatement declaracionEnfermedades = conectorBD.consulta(consulta);
            declaracionEnfermedades.setInt(1, paciente.getId());
            declaracionEnfermedades.setInt(2, i);
            declaracionEnfermedades.setString(3, paciente.getEnfermedadesPrevias().get(i));
            declaracionEnfermedades.execute();
        }
                        
        conectorBD.desconectar();
    }
}
