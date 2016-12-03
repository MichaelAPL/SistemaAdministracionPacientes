package vistas;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milka
 */
public class VentanaPaseLista extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private static VentanaPaseLista ventanaPaseLista;

    private VentanaPaseLista() {
        initComponents();
        inicializarTablaPacientes();
    }

    public static VentanaPaseLista obtenerUnicaVentana() {
        if (ventanaPaseLista == null) {
            ventanaPaseLista = new VentanaPaseLista();
        }
        ventanaPaseLista.setVisible(true);
        return ventanaPaseLista;
    }

    private void inicializarTablaPacientes() {

        String[] cabecera = {"ID", "Nombre", "Apellidos", "Suero", "Dosis EDTA",
            "Numero de Sesión", "Asistencia"};
        Object cuerpo[][] = {};

        modelo = new DefaultTableModel(cuerpo, cabecera) {
            Class[] types = {Integer.class, String.class, String.class, String.class,
                Integer.class, Integer.class, Boolean.class};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };

        tablaDeSesiones.setModel(modelo);
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JButton getBotonGuardarCambios() {
        return botonGuardarCambios;
    }

    public JTable getTablaDeSesiones() {
        return tablaDeSesiones;
    }
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        tablaDeSesiones = new javax.swing.JTable();
        botonGuardarCambios = new javax.swing.JButton();

        tablaDeSesiones.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tablaDeSesiones);

        botonGuardarCambios.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardarCambios)
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonGuardarCambios)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaDeSesiones;
    // End of variables declaration//GEN-END:variables
}
