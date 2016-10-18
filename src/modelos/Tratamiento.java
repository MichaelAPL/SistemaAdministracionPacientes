/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelos.enums.Suero;

/**
 *
 * @author miguelangel
 */
public class Tratamiento {
    private String clavePaciente;
    private Suero suero;
    private int dosis_EDTA_ml;
    private int numeroDeSuerosAPlicados;
    
    public Tratamiento(String clavePaciente, int dosisEDTA){
        this.clavePaciente = clavePaciente;
        this.dosis_EDTA_ml = dosisEDTA;
        this.numeroDeSuerosAPlicados = 0;
    }
    
    public Tratamiento(int dosisEDTA){
        this.dosis_EDTA_ml = dosisEDTA;
    }

    public String getClavePaciente() {
        return clavePaciente;
    }
    
    public void setClavePaciente(String clavePaciente){
        this.clavePaciente = clavePaciente;
    }
    
    public int getDosisEDTA(){
        return this.dosis_EDTA_ml;
    }
    
    public Suero sueroAaplicar(){
        if(this.numeroDeSuerosAPlicados != 0 && 
            this.numeroDeSuerosAPlicados % 5 == 0){
            return suero.MINERAL;
        }else{
            return suero.QUELANTE;
        }
    }
    
    public int getNumeroSuerosAplicados(){
        return this.numeroDeSuerosAPlicados;
    }
    
    public void agregarSueroAlHistorial(){
        this.numeroDeSuerosAPlicados ++;
    }
}
