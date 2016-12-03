/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelos.AdministradorInventario;
import vistas.VentanaInventario;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class TestInventario {
    
    public static void main(String[] args) {        
        VentanaInventario ventanaInventario = VentanaInventario.obtenerUnicaVentanaInventario();
        ventanaInventario.mostrarInventarioInsumos(
            AdministradorInventario.obtenerUnicoAdministradorInventario().obtenerInventarioInsumos());
        
    }   
}
