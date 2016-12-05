/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorRegistro;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Paciente;
import modelos.Persona;
import modelos.Tratamiento;

/**
 *
 * @author Milka
 */
public class VentanaRegistroPacientes extends javax.swing.JFrame {

    /**
     * Creates new form VentanaRegistroPacientes
     */
    private static VentanaRegistroPacientes ventanaRegistro;
    private ControladorRegistro controladorRegistro;
    private ArrayList<String> enfermedadesPrevias;
    private ArrayList<String> medicamentosExternos;

    private VentanaRegistroPacientes() {
        initComponents();
        this.controladorRegistro = new ControladorRegistro();
        inicializarTablaPadecimientos();
        inicializarTablaMedicamentos();
        setLocationRelativeTo(null);
        
    }
    
    public static VentanaRegistroPacientes obtenerUnicaVentanaRegistroPacientes(){
        if (ventanaRegistro == null) {
            ventanaRegistro = new VentanaRegistroPacientes();
        }
        
        ventanaRegistro.setVisible(true);
        return ventanaRegistro;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopUpMenu = new javax.swing.JPopupMenu();
        jEliminarEnfermedad = new javax.swing.JMenuItem();
        jPopUpMenu2 = new javax.swing.JPopupMenu();
        jEliminarMedicamento = new javax.swing.JMenuItem();
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
        jLabel1 = new javax.swing.JLabel();
        medicamento = new javax.swing.JTextField();
        scrollTabla1 = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable();
        añadirEnfermedad = new javax.swing.JButton();
        añadirMedicamento = new javax.swing.JButton();

        jEliminarEnfermedad.setText("Eliminar");
        jEliminarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarEnfermedadActionPerformed(evt);
            }
        });
        jPopUpMenu.add(jEliminarEnfermedad);

        jEliminarMedicamento.setText("Eliminar");
        jEliminarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarMedicamentoActionPerformed(evt);
            }
        });
        jPopUpMenu2.add(jEliminarMedicamento);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        etiquetaPadecimientos.setText("Enfermedades Previas");

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
        tablaPadecimientos.setComponentPopupMenu(jPopUpMenu);
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

        jLabel1.setText("Medicamentos");

        medicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                medicamentoKeyPressed(evt);
            }
        });

        tablaMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaMedicamentos.setComponentPopupMenu(jPopUpMenu2);
        scrollTabla1.setViewportView(tablaMedicamentos);

        añadirEnfermedad.setText("+");
        añadirEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirEnfermedadActionPerformed(evt);
            }
        });

        añadirMedicamento.setText("+");
        añadirMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirMedicamentoActionPerformed(evt);
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
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(etiquetaDireccion)
                                .addGap(18, 18, 18)
                                .addComponent(direccion))
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
                                .addComponent(etiquetaApellidos)
                                .addGap(18, 18, 18)
                                .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(etiquetaPadecimientos)
                                        .addGap(2, 2, 2)
                                        .addComponent(padecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(añadirEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(scrollTabla1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(3, 3, 3)
                                        .addComponent(medicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(añadirMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(etiquetaEdad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(botonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(etiquetaEdad)
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
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(etiquetaPadecimientos)
                                    .addComponent(padecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(medicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(añadirEnfermedad)
                                    .addComponent(añadirMedicamento))
                                .addGap(18, 18, 18)
                                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(botonGuardar))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        Persona persona = new Persona(nombres.getText(), apellidos.getText(),
                direccion.getText(), localidad.getText(),
                telefono.getText(), Integer.parseInt(edad.getText()));

        Tratamiento tratamiento = new Tratamiento(Integer.parseInt(this.EDTA.getText()));

        Paciente paciente = new Paciente(persona, this.medicamentosExternos,
                this.enfermedadesPrevias, tratamiento);
        
        controladorRegistro.mandarAAsistenteNuevoPaciente(paciente);
        ventanaRegistro.dispose();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edadKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_edadKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void EDTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EDTAKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_EDTAKeyTyped

    private void padecimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_padecimientoKeyPressed
        char caracter = evt.getKeyChar();
    }//GEN-LAST:event_padecimientoKeyPressed

    private void medicamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_medicamentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicamentoKeyPressed

    private void añadirEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirEnfermedadActionPerformed
        if(!this.padecimiento.getText().equals("")){
            this.enfermedadesPrevias.add(padecimiento.getText());
            actualizarDatosTabla(this.tablaPadecimientos, this.enfermedadesPrevias);
            this.padecimiento.setText("");
        }        
    }//GEN-LAST:event_añadirEnfermedadActionPerformed

    private void añadirMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirMedicamentoActionPerformed
        if(!this.medicamento.getText().equals("")){
            this.medicamentosExternos.add(medicamento.getText());
            actualizarDatosTabla(this.tablaMedicamentos, this.medicamentosExternos);
            this.medicamento.setText("");
        }        
    }//GEN-LAST:event_añadirMedicamentoActionPerformed

    private void jEliminarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarEnfermedadActionPerformed
        eliminarEnfermedad(this.tablaPadecimientos);
    }//GEN-LAST:event_jEliminarEnfermedadActionPerformed

    private void jEliminarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarMedicamentoActionPerformed
        eliminarMedicamento(this.tablaMedicamentos);
    }//GEN-LAST:event_jEliminarMedicamentoActionPerformed

    private void inicializarTablaPadecimientos() {
        this.enfermedadesPrevias = new ArrayList();
        this.tablaPadecimientos.setModel(crearCuerpoTabla("Padecimientos Previos"));
    }

    private void inicializarTablaMedicamentos() {
        this.medicamentosExternos = new ArrayList();
        this.tablaMedicamentos.setModel(crearCuerpoTabla("Medicamentos Externos"));
    }

    private DefaultTableModel crearCuerpoTabla(String nombreCabecera) {
        DefaultTableModel modelo;
        String cabecera[] = {nombreCabecera};
        String datos[][] = {};
        modelo = new DefaultTableModel(datos, cabecera);
        return modelo;
    }
    
    private void actualizarDatosTabla(JTable tabla, ArrayList<String> datos){
        String cabecera[] = {tabla.getColumnName(0)};
        String[][] cuerpo= new String[datos.size()][1];
        for (int i = 0; i < datos.size(); i++) {
            cuerpo[i][0] = datos.get(i);
        }
        DefaultTableModel modelo = new DefaultTableModel(cuerpo, cabecera);
        tabla.setModel(modelo);
    }
    
    private void eliminarEnfermedad(JTable tabla){
        this.enfermedadesPrevias.remove(tabla.getSelectedRow());
        actualizarDatosTabla(tabla, this.enfermedadesPrevias);
    }
    
    private void eliminarMedicamento(JTable tabla){
        this.medicamentosExternos.remove(tabla.getSelectedRow());
        actualizarDatosTabla(tabla, this.medicamentosExternos);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EDTA;
    private javax.swing.JTextField apellidos;
    private javax.swing.JButton añadirEnfermedad;
    private javax.swing.JButton añadirMedicamento;
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
    private javax.swing.JMenuItem jEliminarEnfermedad;
    private javax.swing.JMenuItem jEliminarMedicamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopUpMenu;
    private javax.swing.JPopupMenu jPopUpMenu2;
    private javax.swing.JTextField localidad;
    private javax.swing.JTextField medicamento;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField padecimiento;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JScrollPane scrollTabla1;
    private javax.swing.JTable tablaMedicamentos;
    private javax.swing.JTable tablaPadecimientos;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
