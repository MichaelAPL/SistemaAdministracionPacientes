
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
    VentanillaPaseDeLista ventana;
    
    public PaseDeLista(ArrayList<Paciente> pacientes){
        this.pacientes = pacientes;
        ventana = new VentanillaPaseDeLista();
        crearPaseDeLista();
        ventana.setVisible(true);
    }
    
    private void crearPaseDeLista(){
        for (int i = 0; i < pacientes.size(); i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setText(pacientes.get(i).getNombres()+" "+pacientes.get(i).getApellidos()+" -- Tipo:"+pacientes.get(i).getSiguienteCita()+" - EDTA:"+pacientes.get(i).getDosis_ml_EDTA());
            ventana.add(checkBox);
        }
    }
    
    
    
    
}
