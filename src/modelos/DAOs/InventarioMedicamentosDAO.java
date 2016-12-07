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
    private final int INDICE_NOMBRE = 1;
    private final int INDICE_EXISTENCIAS = 2;
    private final int INDICE_MLS_UNIDAD = 3;
    private final int INDICE_MLS_TOTALES = 4;
    private final int INDICE_COSTO_UNIDAD = 5;
    
    public InventarioMedicamentosDAO(){
        this.conectorBD = new ConectorBD();
    }
    
    public void actualizar(InventarioMedicamentos medicamento) throws SQLException{
        conectorBD.conectar();
        
        String consulta = "UPDATE InventarioMedicamentos SET Unidades_Existentes = ?,"
                + "Mililitros_Por_Unidad = ?,"
                + "Mililitros_Totales_Existentes = ?,"
                + "Costo_Por_Unidad = ?"
                + "where Nombre_Medicamento = ?";
        int INDICE_Clausula = 5;
        
        PreparedStatement declaracion = conectorBD.consulta(consulta);
        
        declaracion.setDouble(this.INDICE_EXISTENCIAS-1, medicamento.getUnidadesExistentes());
        declaracion.setInt(this.INDICE_MLS_UNIDAD-1, medicamento.getMililitrosPorUnidad());
        declaracion.setInt(this.INDICE_MLS_TOTALES-1, medicamento.getCantidadTotalMililitros());
        declaracion.setDouble(this.INDICE_COSTO_UNIDAD-1, medicamento.getCostoUnitario());
        declaracion.setString(INDICE_Clausula, medicamento.getNombre());
        
        declaracion.execute();
        
        this.conectorBD.desconectar();
    }
    
    public ArrayList<Insumo> recuperarTodoInventarioMedicamentos() throws SQLException{
        conectorBD.conectar();
        
        String consulta = "select * from InventarioMedicamentos";
        
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);
        
        ResultSet resultado = declaracionDeRecuperacion.executeQuery();
        
        //*************************
        ArrayList<Insumo> inventarioMedicamentos = new ArrayList();
        
        while(resultado.next()){
            InventarioMedicamentos medicamento = new InventarioMedicamentos(resultado.getString(this.INDICE_NOMBRE), 
                    resultado.getInt(this.INDICE_MLS_UNIDAD), 
                    resultado.getInt(this.INDICE_MLS_TOTALES), 
                    resultado.getDouble(this.INDICE_COSTO_UNIDAD));
            inventarioMedicamentos.add(medicamento);
        }
        
        this.conectorBD.desconectar();
        
        return inventarioMedicamentos;
    }
}
