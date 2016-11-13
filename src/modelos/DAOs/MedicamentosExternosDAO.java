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
public class MedicamentosExternosDAO {
    
    private ConectorBD conectorBD;
    
    public MedicamentosExternosDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public void crearMedicamentosExternos(Paciente paciente) throws SQLException{
        conectorBD.conectar();
        
        String camposMedicamentos = "Paciente_ID, numMedicamento, NombreMedicamento";
        String consulta = "INSERT INTO MedicamentosExternos ("+camposMedicamentos+")" + 
                " VALUES (?,?,?)";
        
        for (int i = 0; i < paciente.getMedicamentosExternos().size(); i++) {
            PreparedStatement declaracionMedicamentos = conectorBD.consulta(consulta);
            declaracionMedicamentos.setInt(1, paciente.getId());
            declaracionMedicamentos.setInt(2, i);
            declaracionMedicamentos.setString(3, paciente.getMedicamentosExternos().get(i));
            declaracionMedicamentos.execute();
        }
        
        conectorBD.desconectar();
    }
}
