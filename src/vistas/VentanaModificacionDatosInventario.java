/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.naming.spi.NamingManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class VentanaModificacionDatosInventario extends javax.swing.JFrame {
    
    public static VentanaModificacionDatosInventario ventanaModificacionDatos;

    private VentanaModificacionDatosInventario() {
        initComponents();
        setLocationRelativeTo(null);
        etiquetaMls.setVisible(false);
        MlsModificado.setVisible(false);
    }
    
    public static VentanaModificacionDatosInventario obtenerVentanaModificacionDatosInventario(){
        if(ventanaModificacionDatos == null){
            ventanaModificacionDatos = new VentanaModificacionDatosInventario();
        }else{
            ventanaModificacionDatos.setVisible(true);
        }
        return ventanaModificacionDatos;
    } 

    public JTextField getMlsModificado() {
        return MlsModificado;
    }

    public JLabel getEtiquetaCosto() {
        return etiquetaCosto;
    }

    public JLabel getEtiquetaMls() {
        return etiquetaMls;
    }

    public JTextField getNuevoCosto() {
        return nuevoCosto;
    }

    public JComboBox getOpcionesMenu() {
        return opcionesMenu;
    }

    public JButton getAplicarCambios() {
        return aplicarCambios;
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionesMenu = new javax.swing.JComboBox<>();
        nuevoCosto = new javax.swing.JTextField();
        etiquetaCosto = new javax.swing.JLabel();
        etiquetaMls = new javax.swing.JLabel();
        MlsModificado = new javax.swing.JTextField();
        aplicarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificacion Inventario");

        opcionesMenu.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        etiquetaCosto.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        etiquetaCosto.setText("Costo");

        etiquetaMls.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        etiquetaMls.setText("Mlts");

        aplicarCambios.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        aplicarCambios.setText("Aplicar Cambios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(opcionesMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaCosto)
                            .addComponent(nuevoCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MlsModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaMls)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 102, Short.MAX_VALUE)
                        .addComponent(aplicarCambios)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCosto)
                    .addComponent(etiquetaMls))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcionesMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MlsModificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(aplicarCambios)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MlsModificado;
    private javax.swing.JButton aplicarCambios;
    private javax.swing.JLabel etiquetaCosto;
    private javax.swing.JLabel etiquetaMls;
    private javax.swing.JTextField nuevoCosto;
    private javax.swing.JComboBox<String> opcionesMenu;
    // End of variables declaration//GEN-END:variables
}
