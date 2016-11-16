
package vistas;

import controladores.ControladorBusqueda;
import java.util.ArrayList;
import modelos.Paciente;

public class VentanaBusqueda extends javax.swing.JFrame {
    
    private static VentanaBusqueda ventanaBusqueda;
    private ControladorBusqueda controladorBusqueda;
    
    private VentanaBusqueda() {
        initComponents();
        setVisible(true);
        controladorBusqueda = new ControladorBusqueda();
    }
    
    public static VentanaBusqueda obtenerUnicaVentanaBusqueda(){
        if(ventanaBusqueda==null){
            ventanaBusqueda = new VentanaBusqueda();
        }
        return ventanaBusqueda;
    }
    
    public void mostrarPacientes(ArrayList<Paciente> pacientes){
        String[] nombresPacientes = new String [pacientes.size()];
        for (int i = 0; i < pacientes.size(); i++) {
            nombresPacientes[i] = pacientes.get(i).getId() + ":" +
                pacientes.get(i).getNombres()+ " " + pacientes.get(i).getApellidos();
        }
        
        listaPacientes.setListData(nombresPacientes);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombresPaciente = new javax.swing.JTextField();
        etiquetaTextoIntroduccion = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPacientes = new javax.swing.JList();
        botonIr = new javax.swing.JButton();
        etiquetaTextoSeleccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaTextoIntroduccion.setText("Introduzca los nombres y apellidos del paciente que se desea buscar.");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPaciente(evt);
            }
        });

        listaPacientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaPacientes);

        botonIr.setText("Ir");
        botonIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irDatosPaciente(evt);
            }
        });

        etiquetaTextoSeleccion.setText("Seleccione el paciente.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(botonIr)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(etiquetaTextoSeleccion))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiquetaTextoIntroduccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(botonBuscar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTextoIntroduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(botonBuscar)
                .addGap(18, 18, 18)
                .addComponent(etiquetaTextoSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonIr)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void irDatosPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIrActionPerformed
        if (listaPacientes.getSelectedValue() != null) {
            String[] texto = String.valueOf(listaPacientes.getSelectedValue()).split(":");
            controladorBusqueda.obtencionDatosPaciente(texto[0]);
        }
        ventanaBusqueda.dispose();
    }//GEN-LAST:event_botonIrActionPerformed

    private void buscarPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
       if (nombresPaciente.getText() != null) {
            controladorBusqueda.busquedaPaciente(nombresPaciente.getText());
        }
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonIr;
    private javax.swing.JLabel etiquetaTextoIntroduccion;
    private javax.swing.JLabel etiquetaTextoSeleccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaPacientes;
    private javax.swing.JTextField nombresPaciente;
    // End of variables declaration//GEN-END:variables
}
