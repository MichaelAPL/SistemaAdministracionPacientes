/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


/**
 *
 * @author Milka
 */
public class IntervaloFecha{
   
    private Fecha superior;
    private Fecha inferior;
    
    public IntervaloFecha(int mes, int año){
        inferior = new Fecha(1, mes, año);
        setSuperior(mes, año);
    }

    public Fecha getSuperior() {
        return superior;
    }

    public Fecha getInferior() {
        return inferior;
    }
    
    private void setSuperior(int mes, int año){
        final int  ENERO = 1, FEBRERO = 2, MARZO = 3, ABRIL = 4, MAYO = 5,
                JUNIO = 6, JULIO = 7, AGOSTO = 8, SEPTIEMBRE = 9, OCTUBRE = 10,
                NOVIEMBRE = 11, DICIEMBRE = 12;
        switch(mes){
            case ENERO:
            case MARZO:
            case MAYO:
            case JULIO:
            case AGOSTO:
            case OCTUBRE:
            case DICIEMBRE:
                superior = new Fecha(31, mes, año);
                break;
            case ABRIL:
            case JUNIO:
            case SEPTIEMBRE:
            case NOVIEMBRE:
                superior = new Fecha(30, mes, año);
                break;
            case FEBRERO:
                superior = new Fecha(28, mes, año);
                break;
            default:
                System.out.println("No existe el mes");
                
        }
                
    }
    
    
}
