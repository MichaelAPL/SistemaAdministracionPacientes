package ventanillas;

import consultorio.Paciente;
import gestoresDeVentanillas.ControladorCitas;
import java.util.ArrayList;
import javax.swing.JCheckBox;

/**
 *
 * @author Milka
 */
public class VentanillaPaseDeLista extends javax.swing.JFrame {

    ControladorCitas controladorCitas;
    ArrayList<JCheckBox> arregloCheckBox;
    
    public VentanillaPaseDeLista() {
        initComponents();
        arregloCheckBox = new ArrayList();
        controladorCitas = new ControladorCitas();
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
        for (int indice = 0; indice < arregloCheckBox.size(); indice++) {
            JCheckBox checkBox = arregloCheckBox.get(indice);
            if(checkBox.isSelected()){
                controladorCitas.asistenciaDePacientes(indice);
            }
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
