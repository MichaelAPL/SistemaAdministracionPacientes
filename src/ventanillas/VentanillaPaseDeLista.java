package ventanillas;

import consultorio.Paciente;
import java.util.ArrayList;
import javax.swing.JCheckBox;

/**
 *
 * @author Milka
 */
public class VentanillaPaseDeLista extends javax.swing.JFrame {

    ArrayList<JCheckBox> arregloCheckBox;
    public VentanillaPaseDeLista() {
        initComponents();
        arregloCheckBox = new ArrayList();
    }

    public void crearListaDeCitasHoy(ArrayList<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setText(paciente.getNombres() + " " + paciente.getApellidos() + " -- Tipo:" + paciente.getSiguienteCita() + " - EDTA:" + paciente.getDosis_ml_EDTA());
            add(checkBox);
            arregloCheckBox.add(checkBox);
        }
    }
    
    public void buscarCheckBox(){
        for (JCheckBox checkBox : arregloCheckBox) {
            checkBox.
        }
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
