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
    private Aplicacion ultimaAplicacion;
    private int dosis_EDTA_ml;
    private int numeroDeSuerosAPlicados;
    
//To Eliminate
    private Suero suero;
    private int numeroDeSueros;
    

    public Tratamiento(String clavePaciente, int dosisEDTA) {
        this.clavePaciente = clavePaciente;
        this.dosis_EDTA_ml = dosisEDTA;
        this.numeroDeSueros = 0;
    }

    public Tratamiento(int dosisEDTA) {
        this.dosis_EDTA_ml = dosisEDTA;
    }

    public String getClavePaciente() {
        return clavePaciente;
    }

    public void setClavePaciente(String clavePaciente) {
        this.clavePaciente = clavePaciente;
    }

    public int getDosisEDTA() {
        return this.dosis_EDTA_ml;
    }

    //devuelve el tipo de suero a aplicar según el número de suero que toca aplicar

    public Suero sueroAaplicar() {
        if (this.numeroDeSuerosAPlicados != 0
            && this.numeroDeSuerosAPlicados % 5 == 0) {
            return suero.MINERAL;
        } else {
            return suero.QUELANTE;
        }
    }
    
    public int getNumeroSuerosAplicados(){
        return this.numeroDeSueros;
    }
    
    public void agregarSueroAlHistorial(){
        this.numeroDeSueros ++;
    }
}
