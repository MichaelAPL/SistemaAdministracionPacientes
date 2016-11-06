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
<<<<<<< HEAD
    private int numeroDeSueros;
    
    public Tratamiento(String clavePaciente, int dosisEDTA){
=======
    private int numeroDeSuerosAPlicados;

    public Tratamiento(String clavePaciente, int dosisEDTA) {
>>>>>>> 0a450b78ef93a9392ce02fcf29ad3bcc98167ea2
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
<<<<<<< HEAD
    
    public Suero sueroAaplicar(){
        if(this.numeroDeSueros != 0 && 
            this.numeroDeSueros % 5 == 0){
=======

    //devuelve el tipo de suero a aplicar según el número de suero que toca aplicar

    public Suero sueroAaplicar() {
        if (this.numeroDeSuerosAPlicados != 0
            && this.numeroDeSuerosAPlicados % 5 == 0) {
>>>>>>> 0a450b78ef93a9392ce02fcf29ad3bcc98167ea2
            return suero.MINERAL;
        } else {
            return suero.QUELANTE;
        }
    }
<<<<<<< HEAD
    
    public int getNumeroSuerosAplicados(){
        return this.numeroDeSueros;
    }
    
    public void agregarSueroAlHistorial(){
        this.numeroDeSueros ++;
=======

    public int getNumeroSuerosAplicados() {
        return this.numeroDeSuerosAPlicados;
    }

    public void agregarSueroAlHistorial() {
        this.numeroDeSuerosAPlicados++;
>>>>>>> 0a450b78ef93a9392ce02fcf29ad3bcc98167ea2
    }
}
