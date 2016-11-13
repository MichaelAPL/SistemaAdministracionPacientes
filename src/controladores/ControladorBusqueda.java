/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author Milka
 */
public class ControladorBusqueda {

    private static ControladorBusqueda controladorBusqueda;

    private ControladorBusqueda() {
    }

    public static ControladorBusqueda obtenerUnicoControladorBusqueda() {
        if (controladorBusqueda != null) {
            controladorBusqueda = new ControladorBusqueda();
        }
        return controladorBusqueda;
    }

    public void busquedaPaciente(String nombresPaciente, String apellidosPaciente) {

    }

    public void obtencionDatosPaciente(String nombresYApellidosPaciente) {
        
    }

}
