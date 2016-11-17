
package vistas;
import controladores.ControladorDatosPaciente;
import java.util.ArrayList;
import modelos.Paciente;
/**
 *
 * @author Milka
 */
public class VentanaDatosPaciente extends javax.swing.JFrame {

    public static VentanaDatosPaciente ventanaDatosPaciente;
    private ControladorDatosPaciente controladorDatosPaciente;
    private Paciente paciente;
    
    
    private VentanaDatosPaciente() {
        controladorDatosPaciente = new ControladorDatosPaciente();
        initComponents();
        setVisible(true);
    }
    
    public static VentanaDatosPaciente obtenerUnicaVentanaDatosPaciente(){
        if (ventanaDatosPaciente == null) {
            ventanaDatosPaciente = new VentanaDatosPaciente();
        }
        return ventanaDatosPaciente;
    }
    
    public void mostrarDatosPaciente(Paciente paciente){
        this.paciente = paciente;
        nombresPaciente.setText(paciente.getNombres());
        apellidosPaciente.setText(paciente.getApellidos());
        localidadPaciente.setText(paciente.getLocalidad());
        edadPaciente.setText(String.valueOf(paciente.getEdad()));
        direccionPaciente.setText(paciente.getDireccion());
        dosisEDTApaciente.setText(String.valueOf(paciente.getTratamiento().getDosisEDTA()));
        telefonoPaciente.setText(paciente.getTelefono());
        
        
        mostrarEnfermedades(paciente.getEnfermedadesPrevias());
        mostrarMedicamentos(paciente.getMedicamentosExternos());
    }
    
    private void mostrarEnfermedades(ArrayList <String> enfermedadesPrevias){
        Object [] enfermedades = new String[enfermedadesPrevias.size()];
        enfermedades = enfermedadesPrevias.toArray(enfermedades);
        tablaEnfermedadesPaciente.setListData(enfermedades);
    }
    
    private void mostrarMedicamentos(ArrayList <String> medicamentosExternos){
        Object [] medicamentos = new String[medicamentosExternos.size()];
        medicamentos = medicamentosExternos.toArray(medicamentos);
        tablaMedicamentosPaciente.setListData(medicamentos);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEnfermedadesPaciente = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMedicamentosPaciente = new javax.swing.JList();
        modificarDatos = new javax.swing.JButton();
        generarReoporte = new javax.swing.JButton();
        nombresPaciente = new javax.swing.JTextField();
        apellidosPaciente = new javax.swing.JTextField();
        edadPaciente = new javax.swing.JTextField();
        direccionPaciente = new javax.swing.JTextField();
        localidadPaciente = new javax.swing.JTextField();
        dosisEDTApaciente = new javax.swing.JTextField();
        telefonoPaciente = new javax.swing.JTextField();
        eliminarEnfermedad = new javax.swing.JButton();
        eliminarMedicamento = new javax.swing.JButton();
        enfermedadNueva = new javax.swing.JTextField();
        insertarEnfermedad = new javax.swing.JButton();
        insertarMedicamento = new javax.swing.JButton();
        medicamentoNuevo = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        jLabel1.setText("Nombres:");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Edad:");

        jLabel4.setText("Dirección:");

        jLabel5.setText("Localidad:");

        jLabel6.setText("DosisEDTA:");

        jLabel7.setText("Teléfono:");

        jLabel8.setText("EnfermedadesPrevias");

        jLabel9.setText("Medicamentos");

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

        modificarDatos.setText("Modificar Datos");
        modificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarDatosActionPerformed(evt);
            }
        });

        generarReoporte.setText("Genera Reporte");
        generarReoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReoporteActionPerformed(evt);
            }
        });

        eliminarEnfermedad.setText("eliminar");
        eliminarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEnfermedadActionPerformed(evt);
            }
        });

        eliminarMedicamento.setText("eliminar");
        eliminarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMedicamentoActionPerformed(evt);
            }
        });

        insertarEnfermedad.setText("insertar");
        insertarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarEnfermedadActionPerformed(evt);
            }
        });

        insertarMedicamento.setText("insertar");
        insertarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarMedicamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(apellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(localidadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(generarReoporte, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(modificarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edadPaciente)
                            .addComponent(direccionPaciente))
                        .addGap(180, 180, 180))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dosisEDTApaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel7))
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enfermedadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertarEnfermedad)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(telefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eliminarEnfermedad)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(medicamentoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(insertarMedicamento))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(eliminarMedicamento))
                                    .addComponent(jLabel9))
                                .addGap(0, 14, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(generarReoporte)
                    .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(modificarDatos)
                    .addComponent(apellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(edadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(direccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(localidadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(dosisEDTApaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(enfermedadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(insertarEnfermedad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(eliminarEnfermedad)
                                        .addGap(66, 66, 66))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eliminarMedicamento)
                                .addGap(65, 65, 65))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel9)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medicamentoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertarMedicamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarDatosActionPerformed
        mandarModificaciones();
    }//GEN-LAST:event_modificarDatosActionPerformed

    private void eliminarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEnfermedadActionPerformed
        if(tablaEnfermedadesPaciente.getSelectedValue()!=null){
            paciente.eliminarEnfermedad(String.valueOf(tablaEnfermedadesPaciente.getSelectedValue()));
        }
        mostrarEnfermedades(paciente.getEnfermedadesPrevias());
    }//GEN-LAST:event_eliminarEnfermedadActionPerformed

    private void eliminarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarMedicamentoActionPerformed
        if(tablaMedicamentosPaciente.getSelectedValue()!=null){
            paciente.eliminarMedicamento(String.valueOf(tablaMedicamentosPaciente.getSelectedValue()));
        }
        mostrarMedicamentos(paciente.getMedicamentosExternos());
    }//GEN-LAST:event_eliminarMedicamentoActionPerformed

    private void insertarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarEnfermedadActionPerformed
        if(enfermedadNueva.getText()!=null){
            paciente.insertarEnfermedad(enfermedadNueva.getText());
            enfermedadNueva.setText("");
        }
        mostrarEnfermedades(paciente.getEnfermedadesPrevias());
    }//GEN-LAST:event_insertarEnfermedadActionPerformed

    private void insertarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarMedicamentoActionPerformed
        if(medicamentoNuevo.getText()!=null){
            paciente.insertarEnfermedad(medicamentoNuevo.getText());
            medicamentoNuevo.setText("");
        }
        mostrarMedicamentos(paciente.getMedicamentosExternos());
    }//GEN-LAST:event_insertarMedicamentoActionPerformed

    private void generarReoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReoporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generarReoporteActionPerformed

    private void mandarModificaciones(){
        paciente.setNombres(nombresPaciente.getText());
        paciente.setApellidos(apellidosPaciente.getText());
        paciente.setDireccion(direccionPaciente.getText());
        paciente.setEdad(Integer.valueOf(edadPaciente.getText()));
        paciente.setLocalidad(localidadPaciente.getText());
        paciente.setTelefono(telefonoPaciente.getText());
        paciente.getTratamiento().setDosis_EDTA_ml(Integer.valueOf(dosisEDTApaciente.getText()));
        
        
        controladorDatosPaciente.actualizarDatosPaciente(paciente);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosPaciente;
    private javax.swing.JTextField direccionPaciente;
    private javax.swing.JTextField dosisEDTApaciente;
    private javax.swing.JTextField edadPaciente;
    private javax.swing.JButton eliminarEnfermedad;
    private javax.swing.JButton eliminarMedicamento;
    private javax.swing.JTextField enfermedadNueva;
    private javax.swing.JButton generarReoporte;
    private javax.swing.JButton insertarEnfermedad;
    private javax.swing.JButton insertarMedicamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
