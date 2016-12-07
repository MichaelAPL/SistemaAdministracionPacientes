/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import modelos.DAOs.InventarioMedicamentosDAO;
import modelos.DAOs.InventarioUtensiliosDAO;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class AdministradorInventario {

    private static AdministradorInventario administradorInventario;
    private InventarioMedicamentosDAO inventarioMedicamentosDAO;
    private InventarioUtensiliosDAO inventarioUtensiliosDAO;

    private AdministradorInventario() {
        inventarioUtensiliosDAO = new InventarioUtensiliosDAO();
        inventarioMedicamentosDAO = new InventarioMedicamentosDAO();
    }

    public static AdministradorInventario obtenerUnicoAdministradorInventario() {
        if (administradorInventario == null) {
            administradorInventario = new AdministradorInventario();
        }
        return administradorInventario;
    }

    public void actualizarInventario(Insumo insumo) {
        try {
            if (insumo instanceof InventarioMedicamentos) {
                inventarioMedicamentosDAO.actualizar((InventarioMedicamentos) insumo);
            } else {
                inventarioUtensiliosDAO.actualizar((InventarioUtensilios) insumo);
            }
        } catch (SQLException ex) {
            MensajesDeDialogo.errorConLaBD();
        }
    }

    public void agregarImporteInvertido(String nombreInsumo, int cantidad, double importe) {
        String descripcion = "Se realizo una compra de " + cantidad + " " + nombreInsumo;
        Contador.llamarContador().agregarImporte(importe, descripcion);
    }

    private Insumo buscarInsumo(String nombreInsumo) {
        ArrayList<Insumo> insumos = AdministradorInventario.
                obtenerUnicoAdministradorInventario().obtenerInventarioInsumos();
        for (int i = 0; i < insumos.size(); i++) {
            if (insumos.get(i).getNombre().equals(nombreInsumo)) {
                return insumos.get(i);
            }
        }
        MensajesDeDialogo.mostrarErrorNoSeEncuentraInsumo();
        return null;
    }

    public void decrementarInsumo(String nombreInsumo, int cantidadDecrementar) {
        Insumo insumo = buscarInsumo(nombreInsumo);
        if (insumo instanceof InventarioMedicamentos) {            
            InventarioMedicamentos in_medicamento = (InventarioMedicamentos) insumo;
            int cantidadMililitrosAct = in_medicamento.getCantidadTotalMililitros() - cantidadDecrementar;
            
            InventarioMedicamentos medicamentoAct = new InventarioMedicamentos(in_medicamento.getNombre(), 
                    in_medicamento.getMililitrosPorUnidad(), cantidadMililitrosAct, in_medicamento.getCostoUnitario());
            System.out.println("Cantidad act: " + cantidadMililitrosAct);
            System.out.println("Cantidad total no act: " + in_medicamento.getCantidadTotalMililitros());
            System.out.println("Cantidad decr: " + cantidadDecrementar);
            double result = cantidadMililitrosAct/in_medicamento.getMililitrosPorUnidad();
            System.out.println("Deberia ser " + result);
            actualizarInventario(medicamentoAct);
        } else {
            InventarioUtensilios in_utensilio = (InventarioUtensilios) insumo;
            in_utensilio.setExistencias(in_utensilio.getExistencias() - cantidadDecrementar);
            actualizarInventario(in_utensilio);
        }

    }

    public ArrayList<Insumo> obtenerInventarioInsumos() {
        ArrayList<Insumo> inventarioInsumo = null;
        try {
            inventarioInsumo = inventarioMedicamentosDAO.recuperarTodoInventarioMedicamentos();
            inventarioInsumo.addAll(inventarioUtensiliosDAO.recuperarTodoInventarioUtensilios());
        } catch (SQLException ex) {
            MensajesDeDialogo.errorConLaBD();
        }

        return inventarioInsumo;
    }

    private void verificarCantidadUnidades(int cantidad, String nombre) {
        int cantidadMinimaUnidades = 10;
        if (cantidad < 40) {
            MensajesDeDialogo.mostrarCantidadInsuficienteInsumos(nombre);
        }
    }
}
