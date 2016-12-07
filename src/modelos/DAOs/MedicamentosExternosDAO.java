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
    
    public void actualizar(Paciente paciente) throws SQLException{
        int INDICE_PACIENTE_ID = 1;
        
        conectorBD.conectar();
        
        String consultaEliminacion = "DELETE FROM MedicamentosExternos "
                + "where Paciente_ID = ?";
        
        PreparedStatement declaracionEliminacion = conectorBD.consulta(consultaEliminacion);
        declaracionEliminacion.setInt(INDICE_PACIENTE_ID, paciente.getId());
        
        declaracionEliminacion.execute();
        
        conectorBD.desconectar();
        
        crearMedicamentosExternos(paciente);
    }
    
    public void crearMedicamentosExternos(Paciente paciente) throws SQLException{
        //indices campos
        int INDICE_PACIENTE_ID = 1;
        int INDICE_NUM_MEDICAMENTO = 2;
        int INDICE_NOMBRE_MEDICAMENTO = 3;
        
        conectorBD.conectar();
        
        String camposMedicamentos = "Paciente_ID, numMedicamento, NombreMedicamento";
        String consulta = "INSERT INTO MedicamentosExternos ("+camposMedicamentos+")" + 
                " VALUES (?,?,?)";
        
        for (int iMedicamento = 0; iMedicamento < paciente.getMedicamentosExternos().size(); iMedicamento++) {
            
            PreparedStatement declaracionMedicamentos = conectorBD.consulta(consulta);
            
            declaracionMedicamentos.setInt(INDICE_PACIENTE_ID, paciente.getId());
            declaracionMedicamentos.setInt(INDICE_NUM_MEDICAMENTO, iMedicamento);
            declaracionMedicamentos.setString(INDICE_NOMBRE_MEDICAMENTO, paciente.
                    getMedicamentosExternos().get(iMedicamento));
            
            declaracionMedicamentos.execute();
        }
        
        conectorBD.desconectar();
    }
    
    public ArrayList<String> getMedicamentosExternos(int pacienteID) throws SQLException{
        conectorBD.conectar();
        ArrayList<String> medicamentosExternos = new ArrayList();
        
        String consulta = "select * from MedicamentosExternos where Paciente_ID = "+ pacienteID;
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        ResultSet resultados = declaracion.executeQuery();
        
        while(resultados.next()){
            medicamentosExternos.add(resultados.getString("NombreMedicamento"));
        }
        
        conectorBD.desconectar();
        return medicamentosExternos;
    }
   
}
