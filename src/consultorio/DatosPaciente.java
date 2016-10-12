/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

/**
 *
 * @author Angel Basto Gonzalez
 */
public enum DatosPaciente {
    NOMBRES(0), 
    APELLIDOS(1), 
    EDAD(2), 
    DIRECCION(3), 
    LOCALIDAD(4), 
    TELEFONO(5), 
    EDTA(6), 
    PADECIMIENTOS_PREVIOS(7), 
    MEDICAMENTOS_EXTERNOS(8);
    
    private final int valor;
    
    DatosPaciente(int valor){
        this.valor = valor;
    }
    
    public int getDato(){
        return valor;
    }
}
