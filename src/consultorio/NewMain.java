/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import gestoresDeVentanillas.ControladorRegistro;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Milka
 */
public class NewMain {

    public static void main(String[] args) {
        ControladorRegistro controlRegistro = new ControladorRegistro();
        VentanaRegistroPacientes ventanaRegistro = new VentanaRegistroPacientes(controlRegistro);
        
        ventanaRegistro.setVisible(true);
    }
    
}
