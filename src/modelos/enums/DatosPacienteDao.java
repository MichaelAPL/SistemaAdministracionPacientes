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
public enum DatosPacienteDao {
    NOMBRE(1),
    APELLIDO(2),
    DIRECCION(3),
    LOCALIDAD(4),
    TELEFONO(5),
    EDAD(6),
    CLV_PACIENTE(7),
    ENFERMEDADES_PREVIAS(8),
    MEDICAMENTOS_EXTERNOS(9),
    FECHA_INSCRIPCION(10);
    
    private final int valor;
    
    DatosPacienteDao(int valor){
        this.valor = valor;
    }
    
    public int getDato(){
        return valor;
    }
}
