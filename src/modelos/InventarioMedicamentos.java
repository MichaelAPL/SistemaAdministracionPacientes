/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class InventarioMedicamentos extends Insumo {
    private int unidadesExistentes;
    private int mililitrosPorUnidad;
    private int cantidadTotalMililitros;
    
    public InventarioMedicamentos(String nombre, int unidadesExistentes, int mililitrosPorUnidad, double costoUnitario) {
        super(nombre, costoUnitario);
        this.unidadesExistentes = unidadesExistentes;
        this.mililitrosPorUnidad = mililitrosPorUnidad;
        this.cantidadTotalMililitros = calcularMililitrosTotal();
    }
    
    private int calcularMililitrosTotal(){
        return getUnidadesExistentes()*getMililitrosPorUnidad();
    }
    
    public int getCantidadTotalMililitros(){
        return cantidadTotalMililitros;
    }

    public int getMililitrosPorUnidad() {
        return mililitrosPorUnidad;
    }
    
    public int getUnidadesExistentes() {
        return unidadesExistentes;
    }
    
    public void setCantidadTotalMililitros(int cantidadTotalMililitros){
        this.cantidadTotalMililitros = cantidadTotalMililitros;
    }

    public void setMililitrosPorUnidad(int mililitrosPorUnidad) {
        this.mililitrosPorUnidad = mililitrosPorUnidad;
    }
    public void setUnidadesExistentes(int unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }
}
