/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

/**
 *
 * @author miguelangel
 */
public class Tratamiento {
    private Suero suero;
    private int dosis_EDTA_ml;
    private int numeroDeSuerosAPlicados;
    
    public Tratamiento(int dosisEDTA){
        this.dosis_EDTA_ml = dosisEDTA;
        this.numeroDeSuerosAPlicados = 0;
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
}
