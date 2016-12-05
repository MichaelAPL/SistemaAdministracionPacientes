/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;



/**
 *
 * @author Milka
 */
public class Fecha{
    
    private final int dia;
    private final int mes;
    private final int año;
    private final Date fecha;
    
    public Fecha(int dia, int mes, int año){
        fecha = new Date();
        fecha.setDate(dia);
        fecha.setMonth(mes);
        fecha.setYear(año);
        this.dia = fecha.getDate();
        this.mes = fecha.getMonth();
        this.año = fecha.getYear();
    }
    
    public Fecha(Date date){
        dia = date.getDate();
        mes = date.getMonth();
        año = date.getYear();
        fecha = date;
    }
    
    public Fecha(){
        fecha = new Date();
        dia = fecha.getDate();
        mes = fecha.getMonth();
        año = fecha.getYear();
    }
    
    public long getTime(){
        return fecha.getTime();
    }
    
    @Override
    public String toString(){
        return dia+ "/" + mes + "/" + año;
    }
    
    public boolean comperTo(Fecha fecha){
        return ((fecha.dia == dia)&&(fecha.mes == mes)&&(fecha.año == año));
        
    
    }
}
