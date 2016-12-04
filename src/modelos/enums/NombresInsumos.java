/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.enums;

/**
 *
 * @author Milka
 */
public enum NombresInsumos {
    EDTA("EDTA", 0),
    PROCAINA("Procaina", 2),
    MVI("M.V.I.", 2),
    MAGNEFUSIN("Magnefusin", 10),
    HARTMANN("Solucion Hartmann", 1),
    MERIT("Merit", 2),
    NORMOGOTERO("Normogotero", 1),
    AGUJA("Agujas Mariposa", 1);
    
    private final String nombre;
    private final int dosis;
    
    NombresInsumos(String nombre, int dosis){
        this.nombre = nombre;
        this.dosis = dosis;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getDosis(){
        return dosis;
    }
}
