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
public class ControladorPrincipal {
    
    public void mostrarVentanaPaseDeLista(){
        ControladorVentanaPaseLista.obtenerControlador();
        ControladorVentanaPaseLista.obtenerControlador().mandarARecepcionistaPacientesConCita();
    }

    public void mostrarVentanaBuscar() {
        ControladorBusqueda.obtenerControlador();
        ControladorBusqueda.obtenerControlador().llamarARecepcionista();
    }

    public void mostrarVentanaRegistroPacientes() {
        ControladorRegistro.obtenerControlador();
        ControladorRegistro.obtenerControlador().llamarRecepcionista();
    }
    
    public void mostrarVentanaInventario(){
//        VentanaInventario ventanaInventario = VentanaInventario.obtenerUnicaVentanaInventario();
//
//        ventanaInventario.mostrarInventarioInsumos(
//                AdministradorInventario.obtenerUnicoAdministradorInventario().obtenerInventarioInsumos());
        ControladorInventario.obtenerControladorInventario();
        ControladorInventario.obtenerControladorInventario().mandarAVentanaInventarioInsumos();
    }
}
