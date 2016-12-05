
package vistas;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
/**
 *
 * @author Milka
 */
public class VentanaDatosPaciente extends javax.swing.JFrame {

    public static VentanaDatosPaciente ventanaDatosPaciente;
    
    
    private VentanaDatosPaciente() {
        initComponents();
        setVisible(true);
    }
    
    public static VentanaDatosPaciente obtenerVentana(){
        if (ventanaDatosPaciente == null) {
            ventanaDatosPaciente = new VentanaDatosPaciente();
        }
        return ventanaDatosPaciente;
    }

    public JTextField getApellidosPaciente() {
        return apellidosPaciente;
    }

    public JTextField getDireccionPaciente() {
        return direccionPaciente;
    }

    public JTextField getDosisEDTApaciente() {
        return dosisEDTApaciente;
    }

    public JTextField getEdadPaciente() {
        return edadPaciente;
    }

    public JButton getEliminarEnfermedad() {
        return eliminarEnfermedad;
    }

    public JButton getEliminarMedicamento() {
        return eliminarMedicamento;
    }

    public JTextField getEnfermedadNueva() {
        return enfermedadNueva;
    }

    public JButton getGenerarReoporte() {
        return generarReporte;
    }

    public JButton getInsertarEnfermedad() {
        return insertarEnfermedad;
    }

    public JButton getInsertarMedicamento() {
        return insertarMedicamento;
    }

    public JTextField getLocalidadPaciente() {
        return localidadPaciente;
    }

    public JTextField getTelefonoPaciente() {
        return telefonoPaciente;
    }
    

    public JTextField getMedicamentoNuevo() {
        return medicamentoNuevo;
    }

    public JButton getModificarDatos() {
        return modificarDatos;
    }

    public JTextField getNombresPaciente() {
        return nombresPaciente;
    }

    public JList getTablaEnfermedadesPaciente() {
        return tablaEnfermedadesPaciente;
    }

    public JList getTablaMedicamentosPaciente() {
        return tablaMedicamentosPaciente;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaApellidos = new javax.swing.JLabel();
        etiquetaEdad = new javax.swing.JLabel();
        etiquetaDireccion = new javax.swing.JLabel();
        etiquetaLocalidad = new javax.swing.JLabel();
        etiquetaDosis = new javax.swing.JLabel();
        etiquetaTelefono = new javax.swing.JLabel();
        etiquetaEnfermedad = new javax.swing.JLabel();
        etiquetaMedicamento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEnfermedadesPaciente = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMedicamentosPaciente = new javax.swing.JList();
        nombresPaciente = new javax.swing.JTextField();
        apellidosPaciente = new javax.swing.JTextField();
        edadPaciente = new javax.swing.JTextField();
        direccionPaciente = new javax.swing.JTextField();
        localidadPaciente = new javax.swing.JTextField();
        dosisEDTApaciente = new javax.swing.JTextField();
        telefonoPaciente = new javax.swing.JTextField();
        enfermedadNueva = new javax.swing.JTextField();
        medicamentoNuevo = new javax.swing.JTextField();
        eliminarEnfermedad = new javax.swing.JButton();
        insertarEnfermedad = new javax.swing.JButton();
        insertarMedicamento = new javax.swing.JButton();
        eliminarMedicamento = new javax.swing.JButton();
        generarReporte = new javax.swing.JButton();
        modificarDatos = new javax.swing.JButton();

        jButton1.setText("jButton1");

        etiquetaNombre.setText("Nombres:");

        etiquetaApellidos.setText("Apellidos");

        etiquetaEdad.setText("Edad:");

        etiquetaDireccion.setText("Dirección:");

        etiquetaLocalidad.setText("Localidad:");

        etiquetaDosis.setText("DosisEDTA:");

        etiquetaTelefono.setText("Teléfono:");

        etiquetaEnfermedad.setText("Enfermedades Previas");

        etiquetaMedicamento.setText("Medicamentos Externos");

        tablaEnfermedadesPaciente.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(tablaEnfermedadesPaciente);

        tablaMedicamentosPaciente.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(tablaMedicamentosPaciente);

        edadPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                evitarCaracteresNoNumericosParaEdad(evt);
            }
        });

        dosisEDTApaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                evitarCaracteresNoNumericosParaEDTA(evt);
            }
        });

        telefonoPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                evitarCaracteresNoNumericosParaTelefono(evt);
            }
        });

        eliminarEnfermedad.setText("eliminar");

        insertarEnfermedad.setText("insertar");

        insertarMedicamento.setText("insertar");

        eliminarMedicamento.setText("eliminar");

        generarReporte.setText("Generar reporte");

        modificarDatos.setText("Modificar datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaLocalidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(localidadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaDosis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dosisEDTApaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etiquetaEnfermedad)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(enfermedadNueva))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(etiquetaTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(telefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(eliminarEnfermedad)
                                    .addComponent(insertarEnfermedad))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaMedicamento)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(medicamentoNuevo)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(eliminarMedicamento))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(insertarMedicamento)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaDireccion)
                                    .addComponent(etiquetaEdad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(direccionPaciente)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(edadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaApellidos)
                                .addGap(18, 18, 18)
                                .addComponent(apellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombresPaciente)
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(generarReporte)
                            .addComponent(modificarDatos))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generarReporte))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaApellidos)
                    .addComponent(apellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificarDatos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaEdad)
                    .addComponent(edadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDireccion)
                    .addComponent(direccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaLocalidad)
                    .addComponent(localidadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDosis)
                    .addComponent(etiquetaTelefono)
                    .addComponent(dosisEDTApaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(etiquetaEnfermedad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(enfermedadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaMedicamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medicamentoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertarMedicamento)
                            .addComponent(insertarEnfermedad))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(eliminarEnfermedad))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(eliminarMedicamento)))))
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosPaciente;
    private javax.swing.JTextField direccionPaciente;
    private javax.swing.JTextField dosisEDTApaciente;
    private javax.swing.JTextField edadPaciente;
    private javax.swing.JButton eliminarEnfermedad;
    private javax.swing.JButton eliminarMedicamento;
    private javax.swing.JTextField enfermedadNueva;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaDosis;
    private javax.swing.JLabel etiquetaEdad;
    private javax.swing.JLabel etiquetaEnfermedad;
    private javax.swing.JLabel etiquetaLocalidad;
    private javax.swing.JLabel etiquetaMedicamento;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JButton generarReporte;
    private javax.swing.JButton insertarEnfermedad;
    private javax.swing.JButton insertarMedicamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField localidadPaciente;
    private javax.swing.JTextField medicamentoNuevo;
    private javax.swing.JButton modificarDatos;
    private javax.swing.JTextField nombresPaciente;
    private javax.swing.JList tablaEnfermedadesPaciente;
    private javax.swing.JList tablaMedicamentosPaciente;
    private javax.swing.JTextField telefonoPaciente;
    // End of variables declaration//GEN-END:variables
}
