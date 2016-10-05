/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import gestoresDeVentanillas.Controlador;
import java.util.ArrayList;

/**
 *
 * @author Milka
 */
public class VentanaRegistroPacientes extends javax.swing.JFrame {

    
    TablaPadecimientos datosPadecimientos = new TablaPadecimientos();
    Controlador controlador;
    
    public VentanaRegistroPacientes(Controlador controlador) {
        initComponents();
        this.controlador = controlador;
        setLocationRelativeTo(null);
        datosPadecimientos.inicializarTabla(tablaPadecimientos);
        this.setVisible(true);
    }
    
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaApellidos = new javax.swing.JLabel();
        etiquetaEdad = new javax.swing.JLabel();
        etiquetaDireccion = new javax.swing.JLabel();
        apellidos = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        etiquetaLocalidad = new javax.swing.JLabel();
        localidad = new javax.swing.JTextField();
        etiquetaTelefono = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        etiquetaDosis = new javax.swing.JLabel();
        EDTA = new javax.swing.JTextField();
        etiquetaPadecimientos = new javax.swing.JLabel();
        padecimiento = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tablaPadecimientos = new javax.swing.JTable();
        nombres = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        edad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiquetaNombre.setText("Nombres:");

        etiquetaApellidos.setText("Apellidos:");

        etiquetaEdad.setText("Edad:");

        etiquetaDireccion.setText("Dirección:");

        etiquetaLocalidad.setText("Localidad:");

        etiquetaTelefono.setText("Teléfono:");

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });

        etiquetaDosis.setText("Dosis de EDTA:");

        EDTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EDTAKeyTyped(evt);
            }
        });

        etiquetaPadecimientos.setText("Padecimientos Previos");

        padecimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                padecimientoKeyPressed(evt);
            }
        });

        tablaPadecimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollTabla.setViewportView(tablaPadecimientos);

        botonGuardar.setText("Registrar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(etiquetaDireccion)
                        .addGap(18, 18, 18)
                        .addComponent(direccion))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(etiquetaNombre)
                                .addGap(18, 18, 18)
                                .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(etiquetaLocalidad)
                                .addGap(18, 18, 18)
                                .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(etiquetaTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(etiquetaDosis)
                                .addGap(18, 18, 18)
                                .addComponent(EDTA, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(etiquetaPadecimientos)
                                .addGap(18, 18, 18)
                                .addComponent(padecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaApellidos)
                                    .addComponent(etiquetaEdad))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(botonGuardar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaApellidos)
                    .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaEdad)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDireccion)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaLocalidad)
                    .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaTelefono)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDosis)
                    .addComponent(EDTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPadecimientos)
                    .addComponent(padecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        ArrayList arregloDeDatos = new ArrayList();
        arregloDeDatos.add(nombres.getText());
        arregloDeDatos.add(apellidos.getText());
        arregloDeDatos.add(edad.getText());
        arregloDeDatos.add(direccion.getText());
        arregloDeDatos.add(localidad.getText());
        arregloDeDatos.add(telefono.getText());
        arregloDeDatos.add(EDTA.getText());
        arregloDeDatos.add(datosPadecimientos.getPadecimientos());
        controlador.crearNuevoPaciente(arregloDeDatos);
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edadKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter<'0'|| caracter>'9') evt.consume();
    }//GEN-LAST:event_edadKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter<'0'|| caracter>'9') evt.consume();
    }//GEN-LAST:event_telefonoKeyTyped

    private void EDTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EDTAKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter<'0'|| caracter>'9') evt.consume();
    }//GEN-LAST:event_EDTAKeyTyped

    private void padecimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_padecimientoKeyPressed
        char caracter = evt.getKeyChar();
    }//GEN-LAST:event_padecimientoKeyPressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EDTA;
    private javax.swing.JTextField apellidos;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField edad;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaDosis;
    private javax.swing.JLabel etiquetaEdad;
    private javax.swing.JLabel etiquetaLocalidad;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPadecimientos;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JTextField localidad;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField padecimiento;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaPadecimientos;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
