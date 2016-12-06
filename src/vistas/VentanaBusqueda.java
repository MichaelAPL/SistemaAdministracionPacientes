
package vistas;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

public class VentanaBusqueda extends javax.swing.JFrame {
    
    private static VentanaBusqueda ventanaBusqueda;
    
    private VentanaBusqueda() {
        initComponents();
        setVisible(true);
    }
    
    public static VentanaBusqueda obtenerVentana(){
        if(ventanaBusqueda==null){
            ventanaBusqueda = new VentanaBusqueda();
        }
        return ventanaBusqueda;
    }

    public JButton getBotonBuscar() {
        return botonBuscar;
    }

    public JButton getBotonIr() {
        return botonIr;
    }

    public JList getListaPacientes() {
        return listaPacientes;
    }

    public JTextField getNombresPaciente() {
        return nombresPaciente;
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombresPaciente = new javax.swing.JTextField();
        etiquetaTextoIntroduccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPacientes = new javax.swing.JList();
        etiquetaTextoSeleccion = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        botonIr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaTextoIntroduccion.setText("Introduzca los nombres y apellidos del paciente que se desea buscar.");

        listaPacientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaPacientes);

        etiquetaTextoSeleccion.setText("Seleccione el paciente.");

        botonBuscar.setText("Buscar");

        botonIr.setText("Ir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiquetaTextoIntroduccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(etiquetaTextoSeleccion))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(botonBuscar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(botonIr)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTextoIntroduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombresPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(botonBuscar)
                .addGap(20, 20, 20)
                .addComponent(etiquetaTextoSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonIr)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
