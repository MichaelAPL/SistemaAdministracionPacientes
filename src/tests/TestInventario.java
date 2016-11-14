/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import controladores.ControladorInventario;
import vistas.VentanaInventario;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class TestInventario {
    
    public static void main(String[] args) {
        ControladorInventario controladorInventario = new ControladorInventario();
        
        VentanaInventario ventanaInventario = new VentanaInventario(controladorInventario);
        ventanaInventario.setVisible(true);
    }   
}
