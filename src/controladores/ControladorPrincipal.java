/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.AdministradorInventario;
import modelos.AsistenteDoctor;
import vistas.VentanaBusqueda;
import vistas.VentanaInventario;
import vistas.VentanaPaseLista;
import vistas.VentanaRegistroPacientes;
/**
 *
 * @author Milka
 */
public class ControladorPrincipal {
    
    public void mostrarVentanaPaseDeLista(){
        VentanaPaseLista ventanaPaseLista = VentanaPaseLista.obtenerUnicaVentana();
        ventanaPaseLista.mostrarPacientesConCita
        (AsistenteDoctor.obtenerUnicoAsistenteDoctor().obtenerListaDePacientesConCita());
    }

    public void mostrarVentanaBuscar() {
        VentanaBusqueda.obtenerUnicaVentanaBusqueda();
    }

    public void mostrarVentanaRegistroPacientes() {
        VentanaRegistroPacientes.obtenerUnicaVentanaRegistroPacientes();
    }
    
    public void mostrarVentanaInventario(){
        VentanaInventario.obtenerUnicaVentanaInventario();
        AdministradorInventario.obtenerUnicoAdministradorInventario().mandarDatosAVentanaInventario();
    }
}
