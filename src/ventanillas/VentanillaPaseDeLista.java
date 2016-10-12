package ventanillas;

import consultorio.AsistenteDoctor;
import consultorio.Paciente;
import gestoresDeVentanillas.ControladorCitas;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milka
 */
public class VentanillaPaseDeLista extends javax.swing.JFrame {

    ControladorCitas controladorCitas;

    public VentanillaPaseDeLista() {
        initComponents();
        controladorCitas = new ControladorCitas();
        this.setVisible(true);

    }
    
    public void setAsistenteControlador(AsistenteDoctor asistente){
        this.controladorCitas.setAsistente(asistente);
    }

    public void crearListaDeCitasHoy(ArrayList<Paciente> pacientes) {
        String[] cabecera = {"Nombre", "Apellidos", "Suero", "Dosis EDTA", "Numero de Sesión", "Asistencia"};
        Object cuerpo[][] = {};
        
        
        DefaultTableModel modelo = new DefaultTableModel(cuerpo, cabecera){
            Class [] types = {String.class, String.class, String.class, Integer.class, Integer.class, Boolean.class};
            
            @Override
            public Class getColumnClass(int columnIndex){
                return types[columnIndex];
            }
        };
        
        this.tablaDeSesiones.setModel(modelo);
        
        for (Paciente paciente : pacientes) {
            Object datosPaciente[] = {paciente.getNombres(), paciente.getApellidos(), " ", 
            paciente.getDosis_ml_EDTA(), paciente.getSiguienteCita().getNumeroDeCita(), false};
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
           if((Boolean)this.tablaDeSesiones.getModel().getValueAt(i, 5) == true){
               controladorCitas.asistenciaDePacientes(i);
           }
        }
    }//GEN-LAST:event_guardarCambiosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarCambios;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaDeSesiones;
    // End of variables declaration//GEN-END:variables
}
