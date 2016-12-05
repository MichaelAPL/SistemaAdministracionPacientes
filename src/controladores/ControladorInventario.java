
package controladores;

import java.util.ArrayList;
import modelos.AdministradorInventario;
import modelos.Insumo;
import vistas.RecepcionVentanaInventario;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class ControladorInventario {
    private final AdministradorInventario administradorInventario;
    private static ControladorInventario controlador;
    
    public ControladorInventario() {
        administradorInventario = AdministradorInventario.obtenerUnicoAdministradorInventario();                
    }
    
    public static ControladorInventario obtenerControladorInventario(){
        if(controlador==null){
            controlador = new ControladorInventario();
        }
        return controlador;
    }
    
    public void llamarARecepcionVentanaInventario(){
        RecepcionVentanaInventario.obtenerRecepcionVentanaInventario();
    }
    
    public void mandarModificacionesAlInventario(Insumo insumo){
        administradorInventario.actualizarInventario(insumo);
    }
    
    public void mandarAVentanaInventarioInsumos(){
        RecepcionVentanaInventario.obtenerRecepcionVentanaInventario().mostrarInventarioInsumo(
            administradorInventario.obtenerInventarioInsumos());
    }
    
    public ArrayList<Insumo> obtenerInventarioInsumo(){
        return administradorInventario.obtenerInventarioInsumos();
    }
    
    public void mandarImporteInsumoAlAdministrador(String nombreInsumo,int cantidad, double costoTotal){
        administradorInventario.agregarImporteInvertido(nombreInsumo, cantidad,costoTotal);
    }
}