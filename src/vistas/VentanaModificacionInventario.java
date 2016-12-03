/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorInventario;
import java.util.ArrayList;
import modelos.Insumo;
import modelos.InventarioMedicamentos;
import modelos.InventarioUtensilios;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class VentanaModificacionInventario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaModificacionInventario
     */
    public static VentanaModificacionInventario ventanaModificacionInventario;
    private ControladorInventario controladorInventario = new ControladorInventario();
    private ArrayList<Insumo> inventarioInsumo;
    
    private VentanaModificacionInventario() {
        initComponents();
        setLocationRelativeTo(null);
        this.controladorInventario = new ControladorInventario();
        insertarOpcionesMenu();
        setVisible(true);
    }
    
    public static VentanaModificacionInventario obtenerUnicaVentanaMoficacionInventario(){
        if(ventanaModificacionInventario == null){
            ventanaModificacionInventario = new VentanaModificacionInventario();
        }else{
            ventanaModificacionInventario.setVisible(true);
        }
        return ventanaModificacionInventario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        producto = new javax.swing.JComboBox();
        existencias = new javax.swing.JSpinner();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificación Inventario");

        producto.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        existencias.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        existencias.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));

        btnAgregar.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombreProducto = String.valueOf(producto.getItemAt(producto.getSelectedIndex()));
        int cantidadInsumosNuevos = Integer.parseInt(String.valueOf(existencias.getValue()));
        int cantidadInsumoTotal = obtenerCantidadInsumoAnterior(producto.getSelectedIndex()) + 
                cantidadInsumosNuevos;
        double costoUnitarioInsumo = inventarioInsumo.get(producto.getSelectedIndex()).getCostoUnitario();
        
        Insumo insumoModificado;
        if(esMedicamento(producto.getSelectedIndex())){
            int mililitrosUnidad = ((InventarioMedicamentos)inventarioInsumo.get(producto.getSelectedIndex())).getMililitrosPorUnidad();
            insumoModificado = new InventarioMedicamentos(
                    nombreProducto, cantidadInsumoTotal, mililitrosUnidad, costoUnitarioInsumo);
        }else{
            System.out.println("Estoy creando el utensilio");
            insumoModificado = new InventarioUtensilios(
                    nombreProducto, cantidadInsumoTotal, costoUnitarioInsumo);
        }
        
        controladorInventario.mandarModificacionesAlInventario(insumoModificado);
        controladorInventario.actualizarVentanaInventario();
        limpiarVentana();
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    private boolean esMedicamento(int indiceSeleccionado){
        if(inventarioInsumo.get(indiceSeleccionado) instanceof InventarioMedicamentos){
            return true;
        }
        return false;
    }
    
    public void limpiarVentana(){
        producto.setSelectedIndex(0);
        existencias.setValue(0);
        ventanaModificacionInventario.dispose();
        ventanaModificacionInventario = null;
    }
    
    private int obtenerCantidadInsumoAnterior(int indiceSeleccionado){
        int insumoAnterior;
        if(esMedicamento(indiceSeleccionado)){
            insumoAnterior = ((InventarioMedicamentos)inventarioInsumo.get(indiceSeleccionado)).getUnidadesExistentes();
        }else{
            insumoAnterior = ((InventarioUtensilios)inventarioInsumo.get(indiceSeleccionado)).getExistencias();
        }
        
        return insumoAnterior;
    }
    
    public void insertarOpcionesMenu(){
        inventarioInsumo = controladorInventario.obtenerInventarioInsumo();
        for(int i=0; i<inventarioInsumo.size(); i++){
            producto.addItem(inventarioInsumo.get(i).getNombre());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JSpinner existencias;
    private javax.swing.JComboBox producto;
    // End of variables declaration//GEN-END:variables
}
