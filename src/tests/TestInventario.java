/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javax.swing.JOptionPane;
import modelos.AdministradorInventario;
import modelos.MensajesDeDialogo;
import vistas.VentanaInventario;
import vistas.VentanaModificacionDatosInventario;
import vistas.VentanaModificacionInventario;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class TestInventario {
    
    public static void main(String[] args) {        
        VentanaModificacionDatosInventario ventana = VentanaModificacionDatosInventario.obtenerVentanaModificacionDatosInventario();
        ventana.setVisible(true);
    }   
}
