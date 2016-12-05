/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milka
 */
public class VentanaRegistroPaciente extends javax.swing.JFrame {

    /**
     * Creates new form VentanaRegistroPaciente
     */
    private static VentanaRegistroPaciente ventana;

    private VentanaRegistroPaciente() {
        initComponents();
        setLocationRelativeTo(null);
        inicializarTablaMedicamentos();
        inicializarTablaPadecimientos();

    }

    public static VentanaRegistroPaciente obtenerUnicaVentana() {
        if (ventana == null) {
            ventana = new VentanaRegistroPaciente();
        }
        return ventana;
    }

    public JTextField getEDTA() {
        return EDTA;
    }

    public JTextField getApellidos() {
        return apellidos;
    }

    public JButton getAñadirEnfermedad() {
        return añadirEnfermedad;
    }

    public JButton getAñadirMedicamento() {
        return añadirMedicamento;
    }

    public JButton getBotonGuardar() {
        return botonGuardar;
    }

    public JTextField getDireccion() {
        return direccion;
    }

    public JTextField getEdad() {
        return edad;
    }

    public JMenuItem getjEliminarEnfermedad() {
        return eliminarEnfermedad;
    }

    public JMenuItem getjEliminarMedicamento() {
        return eliminarMedicamento;
    }

    public JTextField getLocalidad() {
        return localidad;
    }

    public JTextField getMedicamento() {
        return medicamento;
    }

    public JTextField getNombres() {
        return nombres;
    }

    public JTextField getPadecimiento() {
        return padecimiento;
    }

    public JTable getTablaMedicamentos() {
        return tablaMedicamentos;
    }

    public JTable getTablaPadecimientos() {
        return tablaPadecimientos;
    }

    public JTextField getTelefono() {
        return telefono;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopUpMenu = new javax.swing.JPopupMenu();
        eliminarEnfermedad = new javax.swing.JMenuItem();
        jPopUpMenu2 = new javax.swing.JPopupMenu();
        eliminarMedicamento = new javax.swing.JMenuItem();
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
        etiquetaMedicamento = new javax.swing.JLabel();
        medicamento = new javax.swing.JTextField();
        scrollTabla1 = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable();
        añadirEnfermedad = new javax.swing.JButton();
        añadirMedicamento = new javax.swing.JButton();

        eliminarEnfermedad.setText("Eliminar");
        jPopUpMenu.add(eliminarEnfermedad);

        eliminarMedicamento.setText("Eliminar");
        jPopUpMenu2.add(eliminarMedicamento);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaNombre.setText("Nombres:");

        etiquetaApellidos.setText("Apellidos:");

        etiquetaEdad.setText("Edad:");

        etiquetaDireccion.setText("Dirección:");

        etiquetaLocalidad.setText("Localidad:");

        etiquetaTelefono.setText("Teléfono:");

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                evitarCaracteresNoNumericosParaTelefono(evt);
            }
        });

        etiquetaDosis.setText("Dosis de EDTA:");

        EDTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                evitarCaracteresNoNumericosParaEDTA(evt);
            }
        });

        etiquetaPadecimientos.setText("Enfermedades Previas");

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

        edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                evitarCaracteresNoNumericosParaEdad(evt);
            }
        });

        etiquetaMedicamento.setText("Medicamentos");

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

        añadirMedicamento.setText("+");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollTabla1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(etiquetaMedicamento)
                                .addGap(3, 3, 3)
                                .addComponent(medicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(añadirMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaDireccion)
                            .addComponent(etiquetaEdad))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(direccion))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaPadecimientos)
                            .addComponent(padecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaMedicamento)
                            .addComponent(medicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(añadirEnfermedad)
                            .addComponent(añadirMedicamento))
                        .addGap(18, 18, 18)
                        .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(botonGuardar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void evitarCaracteresNoNumericosParaEdad(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_evitarCaracteresNoNumericosParaEdad
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_evitarCaracteresNoNumericosParaEdad

    private void evitarCaracteresNoNumericosParaTelefono(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_evitarCaracteresNoNumericosParaTelefono
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_evitarCaracteresNoNumericosParaTelefono

    private void evitarCaracteresNoNumericosParaEDTA(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_evitarCaracteresNoNumericosParaEDTA
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_evitarCaracteresNoNumericosParaEDTA

    private DefaultTableModel crearCuerpoTabla(String nombreCabecera) {
        DefaultTableModel modelo;
        String cabecera[] = {nombreCabecera};
        String datos[][] = {};
        modelo = new DefaultTableModel(datos, cabecera);
        return modelo;
    }

    private void inicializarTablaPadecimientos() {
        getTablaPadecimientos().setModel(crearCuerpoTabla("Padecimientos Previos"));
    }

    private void inicializarTablaMedicamentos() {
        getTablaMedicamentos().setModel(crearCuerpoTabla("Medicamentos Externos"));
    }
    
    public void limpiarVentana() {
       getNombres().setText(null);
       getApellidos().setText(null);
       getLocalidad().setText(null);
       getDireccion().setText(null);
       getTelefono().setText(null);
       getEdad().setText(null);
       getEDTA().setText(null);
       inicializarTablaMedicamentos();
       inicializarTablaPadecimientos();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EDTA;
    private javax.swing.JTextField apellidos;
    private javax.swing.JButton añadirEnfermedad;
    private javax.swing.JButton añadirMedicamento;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField edad;
    private javax.swing.JMenuItem eliminarEnfermedad;
    private javax.swing.JMenuItem eliminarMedicamento;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaDosis;
    private javax.swing.JLabel etiquetaEdad;
    private javax.swing.JLabel etiquetaLocalidad;
    private javax.swing.JLabel etiquetaMedicamento;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPadecimientos;
    private javax.swing.JLabel etiquetaTelefono;
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
