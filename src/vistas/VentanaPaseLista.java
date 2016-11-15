package vistas;

import modelos.AsistenteDoctor;
import modelos.Paciente;
import controladores.ControladorCitas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milka
 */
public class VentanaPaseLista extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private static VentanaPaseLista ventanaPaseLista;
    private ControladorCitas controladorCitas;

    private VentanaPaseLista() {
        initComponents();
        controladorCitas = new ControladorCitas();
        inicializarTablaPacientes();
        this.setVisible(true);

    }

    public static VentanaPaseLista obtenerUnicaVentana() {
        if (ventanaPaseLista != null) {
            return ventanaPaseLista;

        } else {
            return ventanaPaseLista = new VentanaPaseLista();
        }

    }

    private void inicializarTablaPacientes() {

        String[] cabecera = {"Nombre", "Apellidos", "Suero", "Dosis EDTA",
            "Numero de Sesión", "Asistencia"};
        Object cuerpo[][] = {};

        modelo = new DefaultTableModel(cuerpo, cabecera) {
            Class[] types = {String.class, String.class, String.class,
                Integer.class, Integer.class, Boolean.class};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };

        tablaDeSesiones.setModel(modelo);
    }
    

    public void mostrarPacientesConCita(ArrayList<Paciente> pacientes) {
        int LIMPIAR_FILAS = 0;
        modelo.setRowCount(LIMPIAR_FILAS);
        for (Paciente paciente : pacientes) {
            Object datosPaciente[] = {paciente.getNombres(), paciente.getApellidos(),
                paciente.getTratamiento().getSiguienteAplicacion().getSuero(),
                paciente.getTratamiento().getDosisEDTA(),
                paciente.getTratamiento().getSiguienteAplicacion().getNumAplicacion(),
                false};
            modelo.addRow(datosPaciente);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        tablaDeSesiones = new javax.swing.JTable();
        guardarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaDeSesiones.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tablaDeSesiones);

        guardarCambios.setText("Guardar");
        guardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(guardarCambios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guardarCambios)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarCambiosActionPerformed
        for (int i = 0; i < this.tablaDeSesiones.getModel().getRowCount(); i++) {
            if ((Boolean) this.tablaDeSesiones.getModel().getValueAt(i, 5) == true) {
                controladorCitas.asistenciaDePacientes(i);
            }
        }
        controladorCitas.actualizarListaPacientes();
    }//GEN-LAST:event_guardarCambiosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarCambios;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaDeSesiones;
    // End of variables declaration//GEN-END:variables
}
