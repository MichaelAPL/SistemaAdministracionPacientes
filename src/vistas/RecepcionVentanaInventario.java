/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorInventario;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import modelos.Insumo;
import modelos.InventarioMedicamentos;
import modelos.InventarioUtensilios;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class RecepcionVentanaInventario {
    private static RecepcionVentanaInventario recepcion;
    private VentanaInventario ventanaInventario;
    private VentanaModificacionInventario ventanaModificacionInventario;
    private ControladorInventario controladorInventario;
    private ArrayList<Insumo> inventarioInsumo;
    
    private RecepcionVentanaInventario(){
        ventanaInventario = VentanaInventario.obtenerUnicaVentanaInventario();
        ventanaModificacionInventario = VentanaModificacionInventario.obtenerUnicaVentanaMoficacionInventario();
        controladorInventario = ControladorInventario.obtenerControladorInventario();
        mostrarVentanaModificacionInventario();
        tomarModificacionesInventario();
    }
    
    public static RecepcionVentanaInventario obtenerRecepcionVentanaInventario(){
        if(recepcion == null){
            recepcion = new RecepcionVentanaInventario();
        }
        return recepcion;
    }
    
    public void mostrarInventarioInsumo(ArrayList<Insumo> insumos){
        ventanaInventario.setVisible(true);
        
        int LIMPIAR_FILAS = 0;
        ventanaInventario.getModeloMedicamentos().setRowCount(LIMPIAR_FILAS);
        ventanaInventario.getModeloUtensilios().setRowCount(LIMPIAR_FILAS);
        
        for(int i=0; i<insumos.size(); i++){
            if(insumos.get(i) instanceof InventarioMedicamentos){
                Object datosMedicamentos[] = {insumos.get(i).getNombre(), 
                ((InventarioMedicamentos)insumos.get(i)).getUnidadesExistentes(), 
                ((InventarioMedicamentos)insumos.get(i)).getMililitrosPorUnidad(), 
                ((InventarioMedicamentos)insumos.get(i)).getCantidadTotalMililitros(), 
                ((InventarioMedicamentos)insumos.get(i)).getCostoUnitario()};
            
            ventanaInventario.getModeloMedicamentos().addRow(datosMedicamentos);
            }else{
                Object datosUtensilios[] = {insumos.get(i).getNombre(), 
                ((InventarioUtensilios)insumos.get(i)).getExistencias(), 
                ((InventarioUtensilios)insumos.get(i)).getCostoUnitario()};
            
            ventanaInventario.getModeloUtensilios().addRow(datosUtensilios);
            }
        }
    }
    
    public void mostrarVentanaModificacionInventario(){
        ventanaInventario.getBtnAgregarExistencias().addActionListener((ActionEvent e) -> {
            insertarOpcionesMenuVentanaModificacionInventario();
            ventanaModificacionInventario.setVisible(true);
        });
    }
    
    private void insertarOpcionesMenuVentanaModificacionInventario() {
        inventarioInsumo = controladorInventario.obtenerInventarioInsumo();
        for (int i = 0; i < inventarioInsumo.size(); i++) {
            ventanaModificacionInventario.getMenuInsumo().addItem(inventarioInsumo.get(i).getNombre());
        }
    }
    
    public void tomarModificacionesInventario(){
        ventanaModificacionInventario.getBtnAgregar().addActionListener((ActionEvent e) ->{
            String nombreInsumo = String.valueOf(
                    ventanaModificacionInventario.getMenuInsumo().getSelectedItem());
            int cantidadInsumosNuevos = Integer.parseInt(String.valueOf(
                    ventanaModificacionInventario.getExistencias().getValue()));            
            int cantidadInsumosTotal = cantidadInsumosNuevos + obtenerCantidadInsumosAnterior();
            double costoUnitarioInsumo = inventarioInsumo.get(
                    ventanaModificacionInventario.getMenuInsumo().getSelectedIndex()).getCostoUnitario();
            
            Insumo insumoModificado;
            if(esMedicamento()){
                int mililitrosPorUnidad = ((InventarioMedicamentos)inventarioInsumo.get(
                    ventanaModificacionInventario.getMenuInsumo().getSelectedIndex())).getMililitrosPorUnidad();
                
                insumoModificado = new InventarioMedicamentos(
                        nombreInsumo, cantidadInsumosTotal, mililitrosPorUnidad, costoUnitarioInsumo);
            }else{
                insumoModificado = new InventarioUtensilios(
                    nombreInsumo, cantidadInsumosTotal, costoUnitarioInsumo);
            }
            
            controladorInventario.mandarModificacionesAlInventario(insumoModificado);
            controladorInventario.mandarAVentanaInventarioInsumos();
            
            limpiarVentanaModificaciones();
        });
    }
    
    private int obtenerCantidadInsumosAnterior(){
        int insumoAnterior;
        if(esMedicamento()){
            insumoAnterior = ((InventarioMedicamentos)inventarioInsumo.get(
                ventanaModificacionInventario.getMenuInsumo().getSelectedIndex())).getUnidadesExistentes();
        }else{
            insumoAnterior = ((InventarioUtensilios)inventarioInsumo.get(
                ventanaModificacionInventario.getMenuInsumo().getSelectedIndex())).getExistencias();
        }
        return insumoAnterior;
    }
    
    private boolean esMedicamento(){
        if(inventarioInsumo.get(ventanaModificacionInventario.getMenuInsumo().getSelectedIndex()) 
                instanceof InventarioMedicamentos){
            return true;
        }
        return false;
    }
    
    private void limpiarVentanaModificaciones(){
        ventanaModificacionInventario.getMenuInsumo().setSelectedIndex(0);
        ventanaModificacionInventario.getExistencias().setValue(0);
        ventanaModificacionInventario.dispose();
    }

}
