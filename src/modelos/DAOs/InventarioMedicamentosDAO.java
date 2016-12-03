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
import modelos.Insumo;
import modelos.InventarioMedicamentos;
import modelos.database.ConectorBD;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class InventarioMedicamentosDAO {
    private ConectorBD conectorBD;
    
    public InventarioMedicamentosDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public ArrayList<Insumo> recuperarTodoInventarioMedicamentos() throws SQLException{
        conectorBD.conectar();
        
        String consulta = "select * from InventarioMedicamentos";
        
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);
        
        ResultSet resultado = declaracionDeRecuperacion.executeQuery();
        
        //*************************
        ArrayList<Insumo> inventarioMedicamentos = new ArrayList();
        
        while(resultado.next()){
            InventarioMedicamentos medicamento = new InventarioMedicamentos(resultado.getString("Nombre_Medicamento"), 
                    resultado.getInt("Unidades_Existentes"), 
                    resultado.getInt("Mililitros_Por_Unidad"), 
                    resultado.getDouble("Costo_Por_Unidad"));
            
            inventarioMedicamentos.add(medicamento);
        }
        
        this.conectorBD.desconectar();
        //*************************
        
        return inventarioMedicamentos;
    }
    
    public void actualizar(InventarioMedicamentos medicamento) throws SQLException{
        conectorBD.conectar();
        
        String consulta = "UPDATE InventarioMedicamentos SET Unidades_Existentes = ?,"
                + "Mililitros_Por_Unidad = ?,"
                + "Mililitros_Totales_Existentes = ?,"
                + "Costo_Por_Unidad = ?"
                + "where Nombre_Medicamento = ?";
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        declaracion.setInt(1, medicamento.getUnidadesExistentes());
        declaracion.setInt(2, medicamento.getMililitrosPorUnidad());
        declaracion.setInt(3, medicamento.getCantidadTotalMililitros());
        declaracion.setDouble(4, medicamento.getCostoUnitario());
        declaracion.setString(5, medicamento.getNombre());
        
        declaracion.execute();
        
        this.conectorBD.desconectar();
    }
}
