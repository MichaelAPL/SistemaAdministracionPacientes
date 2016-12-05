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
        fecha.setMonth(mes-1);
        fecha.setYear(año-1900);
        this.dia = fecha.getDate();
        this.mes = fecha.getMonth()+1;
        this.año = configurarAño(fecha.getYear());
    }
    
    public Fecha(Date date){
        dia = date.getDate();
        mes = date.getMonth()+1;
        año = configurarAño(date.getYear());
        fecha = date;
    }
    
    public Fecha(){
        fecha = new Date();
        dia = fecha.getDate();
        mes = fecha.getMonth()+1;
        año = configurarAño(fecha.getYear());
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
    
    private int configurarAño(int año){
        int añoModificado = año+1900;
        return añoModificado;
    }
}
