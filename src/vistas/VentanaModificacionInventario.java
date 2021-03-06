/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class VentanaModificacionInventario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaModificacionInventario
     */
    public static VentanaModificacionInventario ventanaModificacionInventario;
    
    private VentanaModificacionInventario() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public static VentanaModificacionInventario obtenerUnicaVentanaMoficacionInventario(){
        if(ventanaModificacionInventario == null){
            ventanaModificacionInventario = new VentanaModificacionInventario();
        }else{
            ventanaModificacionInventario.setVisible(true);
        }
        return ventanaModificacionInventario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuInsumo = new javax.swing.JComboBox();
        existencias = new javax.swing.JSpinner();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificación Inventario");

        menuInsumo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        existencias.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        existencias.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));

        btnAgregar.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JSpinner getExistencias() {
        return existencias;
    }

    public JComboBox getMenuInsumo() {
        return menuInsumo;
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JSpinner existencias;
    private javax.swing.JComboBox menuInsumo;
    // End of variables declaration//GEN-END:variables
}
