
package vistas;

import controladores.ControladorBusqueda;

public class VentanaBusqueda extends javax.swing.JFrame {
    ControladorBusqueda controladorBusqueda;
    
    public VentanaBusqueda() {
        initComponents();
        controladorBusqueda = ControladorBusqueda.obtenerUnicoControladorBusqueda();
             
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombresPaciente = new javax.swing.JTextField();
        etiquetaTextoIntroduccion = new javax.swing.JLabel();
        apellidosPaciente = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPacientes = new javax.swing.JList();
        botonIr = new javax.swing.JButton();
        etiquetaTextoSeleccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombresPaciente.setText("Nombres del paciente");

        etiquetaTextoIntroduccion.setText("Introduzca los nombres y apellidos del paciente que se desea buscar.");

        apellidosPaciente.setText("Apellidos del paciente");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPaciente(evt);
            }
        });

        listaPacientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(apellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etiquetaTextoIntroduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaTextoSeleccion)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(botonBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(botonIr)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTextoIntroduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonBuscar)
                .addGap(18, 18, 18)
                .addComponent(etiquetaTextoSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonIr)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void irDatosPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIrActionPerformed
        if (listaPacientes.getSelectedValue() != null) {
            controladorBusqueda.obtencionDatosPaciente(String.valueOf(listaPacientes.getSelectedValue()));
        }
    }//GEN-LAST:event_botonIrActionPerformed

    private void buscarPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
       if (nombresPaciente.getText() != null && apellidosPaciente.getText() != null) {
            controladorBusqueda.busquedaPaciente(nombresPaciente.getText(), apellidosPaciente.getText());
        }
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosPaciente;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonIr;
    private javax.swing.JLabel etiquetaTextoIntroduccion;
    private javax.swing.JLabel etiquetaTextoSeleccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaPacientes;
    private javax.swing.JTextField nombresPaciente;
    // End of variables declaration//GEN-END:variables
}
