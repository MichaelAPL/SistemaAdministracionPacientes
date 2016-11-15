/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorInventario;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import modelos.InventarioProducto;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class VentanaInventario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInventario
     */
    
    ControladorInventario controladorInventario = new ControladorInventario();
    
    public VentanaInventario(ControladorInventario controladorInventario) {
        initComponents();
        setLocationRelativeTo(null);
        this.controladorInventario = controladorInventario;
        inicializarTablaInsumos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloVent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInsumos = new javax.swing.JTable();
        btnAgregarExistencias = new javax.swing.JButton();
        btnAgregarNuevoMaterial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario ");

        tituloVent.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        tituloVent.setText("Inventario");

        tablaInsumos.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        tablaInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaInsumos);

        btnAgregarExistencias.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnAgregarExistencias.setText("Agregar Insumos");
        btnAgregarExistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExistenciasActionPerformed(evt);
            }
        });

        btnAgregarNuevoMaterial.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnAgregarNuevoMaterial.setText("Agregar nuevo material");
        btnAgregarNuevoMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevoMaterialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloVent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(btnAgregarExistencias)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarNuevoMaterial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloVent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarExistencias)
                    .addComponent(btnAgregarNuevoMaterial))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarExistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExistenciasActionPerformed
        // TODO add your handling code here:
        VentanaModificacionInventario ventanaModificacion = 
                new VentanaModificacionInventario(controladorInventario);
        
        ventanaModificacion.setVisible(true);
    }//GEN-LAST:event_btnAgregarExistenciasActionPerformed

    private void btnAgregarNuevoMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevoMaterialActionPerformed
        // TODO add your handling code here:
//        VentanaIngresarNuevoProductoInventario ventanaIngresarNuevoProducto =
//                new VentanaIngresarNuevoProductoInventario();
//        
//        ventanaIngresarNuevoProducto.setVisible(true);
    }//GEN-LAST:event_btnAgregarNuevoMaterialActionPerformed

    public void inicializarTablaInsumos(){        
        Vector<String> cabecera = new Vector<String>();
        cabecera.add("Nombre");
        cabecera.add("Cantidad");
        
        ArrayList<InventarioProducto> productos = controladorInventario.obtenerInventarioProductos();
        this.tablaInsumos.setModel(crearCuerpoTabla(cabecera));
    }
    
    public DefaultTableModel crearCuerpoTabla(Vector<String> cabecera){
        DefaultTableModel modelo;
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        datos = obtenerDatosProductos(controladorInventario.obtenerInventarioProductos());
        modelo = new DefaultTableModel(datos, cabecera);
        return modelo;
    }
    
    public Vector<Vector<Object>> obtenerDatosProductos(ArrayList<InventarioProducto> productos){
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        for (int i = 0; i < productos.size(); i++) {
            Vector<Object> fila  = new Vector<Object>();
            
            fila.add(productos.get(i).getNombre());
            fila.add(productos.get(i).getExistencias());
            
            datos.add(fila);
        }
        return datos;
    }
    
//    public void actualizarTablaInsumos(ArrayList<InventarioProducto> productos){
//        Vector<String> cabecera = new Vector<String>();
//        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
//        
//        cabecera.add("Nombre");
//        cabecera.add("Cantidad");
//        
//        for (int i = 0; i < productos.size(); i++) {
//            Vector<Object> fila  = new Vector<Object>();
//            
//            fila.add(productos.get(i).getNombre());
//            fila.add(productos.get(i).getExistencias());
//            
//            datos.add(fila);
//        }
//        
//        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(datos, cabecera);
//        
//        this.tablaInsumos.setModel(modelo);
//    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarExistencias;
    private javax.swing.JButton btnAgregarNuevoMaterial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaInsumos;
    private javax.swing.JLabel tituloVent;
    // End of variables declaration//GEN-END:variables
}
