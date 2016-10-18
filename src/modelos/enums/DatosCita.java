/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.enums;

/**
 *
 * @author Angel Basto Gonzalez
 */
public enum DatosCita {
    FECHA_DE_REALIZACION(1), 
    FECHA_PROGRAMADA(2), 
    NUMERO_DE_CITA(3), 
    REALIZADA(4), 
    CLV_PACIENTE(5);
    
    private final int valor;
    
    DatosCita(int valor){
        this.valor = valor;
    }
    
    public int getDato(){
        return valor;
    }
}
