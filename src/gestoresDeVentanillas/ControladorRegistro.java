package gestoresDeVentanillas;

import consultorio.DatosPaciente;
import java.util.ArrayList;
import consultorio.Paciente;
import consultorio.Persona;

/**
 *
 * @author Milka
 */
public class ControladorRegistro {
    
    public void crearNuevoPaciente(ArrayList arregloDeDatos){
        Paciente pacienteNuevo;
        
        pacienteNuevo = new Paciente(
                new Persona((String)arregloDeDatos.get(DatosPaciente.NOMBRES.getDato()),
                        (String)arregloDeDatos.get(DatosPaciente.APELLIDOS.getDato()),
                        Integer.valueOf((String)arregloDeDatos.get(DatosPaciente.EDAD.getDato())),
                        (String)arregloDeDatos.get(DatosPaciente.DIRECCION.getDato()),
                        (String)arregloDeDatos.get(DatosPaciente.LOCALIDAD.getDato()),
                        (String)arregloDeDatos.get(DatosPaciente.TELEFONO.getDato())),
                Integer.valueOf((String)arregloDeDatos.get(DatosPaciente.EDTA.getDato())),
                (ArrayList)arregloDeDatos.get(DatosPaciente.PADECIMIENTOS_PREVIOS.getDato()),
                (ArrayList)arregloDeDatos.get(DatosPaciente.MEDICAMENTOS_EXTERNOS.getDato()));
 
    }
}
