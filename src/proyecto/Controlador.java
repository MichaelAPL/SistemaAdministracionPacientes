/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

/**
 *
 * @author Milka
 */
public class Controlador {
    
    public void crearNuevoPaciente(ArrayList arregloDeDatos){
        Paciente pacienteNuevo = new Paciente(
        (String)arregloDeDatos.get(0),
        (String)arregloDeDatos.get(1),
        Integer.valueOf((String)arregloDeDatos.get(2)),
        (String)arregloDeDatos.get(3),
        (String)arregloDeDatos.get(4),
        (String)arregloDeDatos.get(5),
        Integer.valueOf((String)arregloDeDatos.get(6)),
        (ArrayList)arregloDeDatos.get(7));
    }
}
