package controladores;

import modelos.enums.DatosPaciente;
import java.util.ArrayList;
import modelos.Paciente;
import modelos.Persona;
import modelos.Tratamiento;

/**
 *
 * @author Milka
 */
public class ControladorRegistro {
    
    public Paciente crearNuevoPaciente(ArrayList arregloDeDatos){
        Persona persona;
        Paciente pacienteNuevo;
        Tratamiento tratamiento;
        
        persona = new Persona((String)arregloDeDatos.get(DatosPaciente.NOMBRES.getDato()),
                        (String)arregloDeDatos.get(DatosPaciente.APELLIDOS.getDato()),
                        Integer.valueOf((String)arregloDeDatos.get(DatosPaciente.EDAD.getDato())),
                        (String)arregloDeDatos.get(DatosPaciente.DIRECCION.getDato()),
                        (String)arregloDeDatos.get(DatosPaciente.LOCALIDAD.getDato()),
                        (String)arregloDeDatos.get(DatosPaciente.TELEFONO.getDato()));
        
        tratamiento = new Tratamiento(Integer.valueOf((String)arregloDeDatos.get(DatosPaciente.EDTA.getDato())));
        
        pacienteNuevo = new Paciente(persona, tratamiento,
                (ArrayList)arregloDeDatos.get(DatosPaciente.PADECIMIENTOS_PREVIOS.getDato()),
                (ArrayList)arregloDeDatos.get(DatosPaciente.MEDICAMENTOS_EXTERNOS.getDato()));
        
        return pacienteNuevo;
    }
}
