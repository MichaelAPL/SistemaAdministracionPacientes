/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import controladores.ControladorRegistro;
import vistas.VentanaRegistroPacientes;

/**
 *
 * @author Milka
 */
public class TestUid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
       ControladorRegistro controladorRegistro = new ControladorRegistro();
       VentanaRegistroPacientes vrc = new VentanaRegistroPacientes(controladorRegistro);               
    }
    
}
