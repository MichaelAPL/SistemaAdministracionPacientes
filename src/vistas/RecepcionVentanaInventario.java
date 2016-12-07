/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorInventario;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import modelos.Insumo;
import modelos.InventarioMedicamentos;
import modelos.InventarioUtensilios;
import modelos.MensajesDeDialogo;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class RecepcionVentanaInventario {
    private static RecepcionVentanaInventario recepcion;
    private VentanaInventario ventanaInventario;
    private VentanaModificacionInventario ventanaModificacionInventario;
    private VentanaModificacionDatosInventario ventanaModificacionDatosInventario;
    private ControladorInventario controladorInventario;
    private ArrayList<Insumo> inventarioInsumo;
    
    private RecepcionVentanaInventario(){
        ventanaInventario = VentanaInventario.obtenerUnicaVentanaInventario();
        ventanaModificacionInventario = 
                VentanaModificacionInventario.obtenerUnicaVentanaMoficacionInventario();
        ventanaModificacionDatosInventario = 
                VentanaModificacionDatosInventario.obtenerVentanaModificacionDatosInventario();
        
        controladorInventario = ControladorInventario.obtenerControladorInventario();
        mostrarVentanasDeModificacionInventario();
        tomarModificacionesInventario();
    }
    
    public static RecepcionVentanaInventario obtenerRecepcionVentanaInventario(){
        if(recepcion == null){
            recepcion = new RecepcionVentanaInventario();
        }
        return recepcion;
    }
    
    private boolean esMedicamento(int indiceSeleecionado){
        if(inventarioInsumo.get(indiceSeleecionado) 
                instanceof InventarioMedicamentos){
            return true;
        }
        return false;
    }
    
    private void insertarOpcionesMenuVentanaModificacionInventario(JComboBox menu) {
        inventarioInsumo = controladorInventario.obtenerInventarioInsumo();
        for (int i = 0; i < inventarioInsumo.size(); i++) {
            menu.addItem(inventarioInsumo.get(i).getNombre());
        }
    }
    
    private void limpiarVentanaModificaciones(){
        ventanaModificacionInventario.getMenuInsumo().setSelectedIndex(0);
        ventanaModificacionInventario.getExistencias().setValue(0);
        ventanaModificacionInventario.dispose();
    }
    
    private void limpiarVentanaModificacionDatosInventario(){
        ventanaModificacionDatosInventario.getMlsModificado().setText("");
        ventanaModificacionDatosInventario.getNuevoCosto().setText("");
        ventanaModificacionDatosInventario.getOpcionesMenu().setSelectedIndex(0);
        ventanaModificacionDatosInventario.dispose();
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
    
    public void mostrarVentanasDeModificacionInventario(){
        ventanaInventario.getBtnAgregarExistencias().addActionListener((ActionEvent e) -> {            
            insertarOpcionesMenuVentanaModificacionInventario(
                ventanaModificacionInventario.getMenuInsumo());
            ventanaModificacionInventario.setVisible(true);
        });
        
        ventanaInventario.getBtnModificarDatos().addActionListener((ActionEvent e) ->{            
            insertarOpcionesMenuVentanaModificacionInventario(
                ventanaModificacionDatosInventario.getOpcionesMenu());
            ventanaModificacionDatosInventario.setVisible(true);
        });
        
    }
    
    private double obtenerCantidadInsumosAnterior(int indiceSeleccionado){
        double insumoAnterior;
        if(esMedicamento(indiceSeleccionado)){
            insumoAnterior = ((InventarioMedicamentos)inventarioInsumo.get(
                indiceSeleccionado)).getUnidadesExistentes();
        }else{
            insumoAnterior = ((InventarioUtensilios)inventarioInsumo.get(
                indiceSeleccionado)).getExistencias();
        }
        return insumoAnterior;
    }
    
    public void tomarModificacionesInventario(){
        ventanaModificacionInventario.getBtnAgregar().addActionListener((ActionEvent e) ->{
            String nombreInsumo = String.valueOf(
                    ventanaModificacionInventario.getMenuInsumo().getSelectedItem());
            int cantidadInsumosNuevos = Integer.parseInt(String.valueOf(
                    ventanaModificacionInventario.getExistencias().getValue()));            
            double cantidadInsumosTotal = cantidadInsumosNuevos + 
                    obtenerCantidadInsumosAnterior(ventanaModificacionInventario.getMenuInsumo().getSelectedIndex());
            double costoUnitarioInsumo = inventarioInsumo.get(
                    ventanaModificacionInventario.getMenuInsumo().getSelectedIndex()).getCostoUnitario();
            
            Insumo insumoModificado;
            if(esMedicamento(ventanaModificacionInventario.getMenuInsumo().getSelectedIndex())){
                int mililitrosPorUnidad = ((InventarioMedicamentos)inventarioInsumo.get(
                    ventanaModificacionInventario.getMenuInsumo().getSelectedIndex())).getMililitrosPorUnidad();
                
                insumoModificado = new InventarioMedicamentos(
                        nombreInsumo, cantidadInsumosTotal, mililitrosPorUnidad, costoUnitarioInsumo);
            }else{
                insumoModificado = new InventarioUtensilios(
                    nombreInsumo, cantidadInsumosTotal, costoUnitarioInsumo);
            }
            
            double importeAgregado = cantidadInsumosNuevos*insumoModificado.getCostoUnitario();
            
            controladorInventario.mandarModificacionesAlInventario(insumoModificado);
            controladorInventario.mandarImporteInsumoAlAdministrador(nombreInsumo, cantidadInsumosNuevos,importeAgregado);
            controladorInventario.mandarAVentanaInventarioInsumos();
            
            limpiarVentanaModificaciones();
        });
        
        ventanaModificacionDatosInventario.getOpcionesMenu().addActionListener((ActionEvent e) ->{
            if(esMedicamento(ventanaModificacionDatosInventario.getOpcionesMenu().getSelectedIndex())){
                ventanaModificacionDatosInventario.getEtiquetaMls().setVisible(true);
                ventanaModificacionDatosInventario.getMlsModificado().setVisible(true);
            }else{
                ventanaModificacionDatosInventario.getMlsModificado().setVisible(false);
                ventanaModificacionDatosInventario.getEtiquetaMls().setVisible(false);
            }
        });
        
        ventanaModificacionDatosInventario.getAplicarCambios().addActionListener((ActionEvent e) ->{
            try{
                String nombreInsumo = String.valueOf(ventanaModificacionDatosInventario.getOpcionesMenu().getSelectedItem());
                double existencias = obtenerCantidadInsumosAnterior(
                        ventanaModificacionDatosInventario.getOpcionesMenu().getSelectedIndex());
                double costoNuevo = Double.parseDouble(String.valueOf(
                        ventanaModificacionDatosInventario.getNuevoCosto().getText()));

                Insumo insumoModificado;

                if (esMedicamento(ventanaModificacionDatosInventario.getOpcionesMenu().getSelectedIndex())) {
                    int mililitrosPorUnidad = Integer.parseInt(
                            ventanaModificacionDatosInventario.getMlsModificado().getText());
                    insumoModificado = new InventarioMedicamentos(nombreInsumo, existencias, mililitrosPorUnidad, costoNuevo);
                } else {
                    insumoModificado = new InventarioUtensilios(nombreInsumo, existencias, costoNuevo);
                }
                controladorInventario.mandarModificacionesAlInventario(insumoModificado);
                controladorInventario.mandarAVentanaInventarioInsumos();
                limpiarVentanaModificacionDatosInventario();
            } catch(Exception ex){
                MensajesDeDialogo.mostrarErrorDatosEntradaIncorrectos();
            }
        });
    }
}
