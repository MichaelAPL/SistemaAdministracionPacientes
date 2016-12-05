
package controladores;

public class ControladorPrincipal {
    
    public void llamarControladorVentanaPaseLista(){
        ControladorPaseLista.obtenerControlador();
        ControladorPaseLista.obtenerControlador().mandarARecepcionistaPacientesConCita();
    }

    public void llamarControladorVentanaBuscar() {
        ControladorBusqueda.obtenerControlador();
        ControladorBusqueda.obtenerControlador().llamarARecepcionista();
    }

    public void llamarControladorVentanaRegistroPacientes() {
        ControladorRegistro.obtenerControlador();
        ControladorRegistro.obtenerControlador().llamarRecepcionista();
    }
    
    public void llamarControladorVentanaInventario(){
        ControladorInventario.obtenerControladorInventario();
        ControladorInventario.obtenerControladorInventario().mandarAVentanaInventarioInsumos();
    }
}
