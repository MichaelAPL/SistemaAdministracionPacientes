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
    
    public InventarioMedicamentos(String nombre, int unidadesExistentes, int mililitrosPorUnidad) {
        super(nombre);
        this.unidadesExistentes = unidadesExistentes;
        this.mililitrosPorUnidad = mililitrosPorUnidad;
        this.cantidadTotalMililitros = calcularMililitrosTotal();
    }
    
    public InventarioMedicamentos(String nombre, int unidadesExistentes, int mililitrosPorUnidad, double costoUnitario) {
        super(nombre, costoUnitario);
        this.unidadesExistentes = unidadesExistentes;
        this.mililitrosPorUnidad = mililitrosPorUnidad;
        this.cantidadTotalMililitros = calcularMililitrosTotal();
    }

    public int getUnidadesExistentes() {
        return unidadesExistentes;
    }

    public void setUnidadesExistentes(int unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }

    public int getMililitrosPorUnidad() {
        return mililitrosPorUnidad;
    }

    public void setMililitrosPorUnidad(int mililitrosPorUnidad) {
        this.mililitrosPorUnidad = mililitrosPorUnidad;
    }
    
    public int getCantidadTotalMililitros(){
        return cantidadTotalMililitros;
    }
    
    private int calcularMililitrosTotal(){
        return getUnidadesExistentes()*getMililitrosPorUnidad();
    }
    
}
