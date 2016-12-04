/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import modelos.AdministradorInventario;
import modelos.Insumo;
import vistas.VentanaInventario;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class ControladorInventario {
    private final AdministradorInventario administradorInventario;
    
    public ControladorInventario() {
        administradorInventario = AdministradorInventario.obtenerUnicoAdministradorInventario();                
    }
    
    public void mandarModificacionesAlInventario(Insumo insumo){
        administradorInventario.actualizarInventario(insumo);
    }
    
    public void actualizarVentanaInventario(){
        VentanaInventario.obtenerUnicaVentanaInventario().mostrarInventarioInsumos(
                administradorInventario.obtenerInventarioInsumos());
    }
    
    public ArrayList<Insumo> obtenerInventarioInsumo(){
        return administradorInventario.obtenerInventarioInsumos();
    }
}