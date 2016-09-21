/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class TablaPadecimientos {
    private  ArrayList padecimientos = new ArrayList();
    
    public void agregarPadecimiento(String padecimiento){
        padecimientos.add(padecimiento);
    }

    public ArrayList getPadecimientos() {
        return padecimientos;
    }
    
    public void eliminarPadecimiento(int index){
        padecimientos.remove(index);
    }
    
    public void inicializarTabla(JTable tablaPadecimientos){
        Vector<String> titulosTabla = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulosTabla.add("Padecimientos");
        
        for(int i=0; i<padecimientos.size(); i++){
            Vector<Object> row  = new Vector<Object>();
            
            row.add(padecimientos.get(i));
            
            datos.add(row);                    
        }
        
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(datos,titulosTabla);
     
        this.establecerModeloJTable(modelo, tablaPadecimientos);
    }
    
    private void establecerModeloJTable(DefaultTableModel modelo, JTable tabla){
        tabla.setModel(modelo);    
    }
}
