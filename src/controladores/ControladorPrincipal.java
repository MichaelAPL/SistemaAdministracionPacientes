
package controladores;

public class ControladorPrincipal {
    
    public void llamarControladorVentanaPaseDeLista(){
        ControladorVentanaPaseLista.obtenerControlador();
        ControladorVentanaPaseLista.obtenerControlador().mandarARecepcionistaPacientesConCita();
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
