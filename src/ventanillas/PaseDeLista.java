
package ventanillas;

import java.util.ArrayList;
import consultorio.*;
import javax.swing.JCheckBox;

/**
 *
 * @author Milka
 */
public class PaseDeLista {
    ArrayList<Paciente> pacientes;
    VentanillaVPaseDeLista ventana;
    
    public PaseDeLista(ArrayList<Paciente> pacientes){
        this.pacientes = pacientes;
        ventana = new VentanillaVPaseDeLista();
        crearPaseDeLista();
        ventana.setVisible(true);
    }
    
    private void crearPaseDeLista(){
        for (Paciente paciente : pacientes) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setText( /* No me deja acceder al tipo de tratamiento*/ paciente.getNombres() + " " + paciente.getApellidos() + " -- Tipo:" + paciente.getSiguienteCita() + /* No me deja acceder al tipo de tratamiento*/
                    " - EDTA:" + paciente.getDosis_ml_EDTA());
            ventana.add(checkBox);
        }
    }
    
    
    
    
}
