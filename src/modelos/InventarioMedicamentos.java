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
    private double unidadesExistentes;
    private int mililitrosPorUnidad;
    private int cantidadTotalMililitros;
    
    public InventarioMedicamentos(String nombre, int mililitrosPorUnidad, int mililitrosTotales, double costoUnitario) {
        super(nombre, costoUnitario);
        this.mililitrosPorUnidad = mililitrosPorUnidad;
        this.cantidadTotalMililitros = mililitrosTotales;
        this.unidadesExistentes = calcularUnidadesExistentes();
    }
    
    public InventarioMedicamentos(String nombre,double unidadesExistentes, int mililitrosPorUnidad, double costoUnitario){
        super(nombre, costoUnitario);
        this.unidadesExistentes = unidadesExistentes;
        this.mililitrosPorUnidad = mililitrosPorUnidad;
        this.cantidadTotalMililitros = calculcarCantidadTotalMililitros();
    }
    
    private double calcularUnidadesExistentes(){
        return getCantidadTotalMililitros()/getMililitrosPorUnidad();
    }
    
    private int calculcarCantidadTotalMililitros(){
        return (int) (getMililitrosPorUnidad()*getUnidadesExistentes());
    }
    
    public int getCantidadTotalMililitros(){
        return cantidadTotalMililitros;
    }

    public int getMililitrosPorUnidad() {
        return mililitrosPorUnidad;
    }
    
    public double getUnidadesExistentes() {
        return unidadesExistentes;
    }
    
    public void setCantidadTotalMililitros(int cantidadTotalMililitros){
        this.cantidadTotalMililitros = cantidadTotalMililitros;
    }

    public void setMililitrosPorUnidad(int mililitrosPorUnidad) {
        this.mililitrosPorUnidad = mililitrosPorUnidad;
    }
    public void setUnidadesExistentes(double unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }
}
