/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelos.enums.NombresInsumos;
import modelos.enums.Suero;

/**
 *
 * @author Milka
 */
public class Boticario {

    private static Boticario farmaceutico;
    private AdministradorInventario administrador;

    private Boticario() {
        administrador = AdministradorInventario.obtenerUnicoAdministradorInventario();
    }

    public static Boticario llamarFarmaceutico() {
        if (farmaceutico == null) {
            farmaceutico = new Boticario();
        }
        return farmaceutico;
    }
    
    public void atenderPaciente(Suero suero, int dosisEDTA){
        prepararSuero(suero, dosisEDTA);
    }

    public void prepararSuero(Suero suero, int dosisEDTA) {
        administrador.decrementarInsumo(NombresInsumos.PROCAINA.getNombre(), NombresInsumos.PROCAINA.getDosis());
        administrador.decrementarInsumo(NombresInsumos.MAGNEFUSIN.getNombre(), NombresInsumos.MAGNEFUSIN.getDosis());
        administrador.decrementarInsumo(NombresInsumos.HARTMANN.getNombre(), NombresInsumos.HARTMANN.getDosis());
        administrador.decrementarInsumo(NombresInsumos.AGUJA.getNombre(), NombresInsumos.AGUJA.getDosis());
        administrador.decrementarInsumo(NombresInsumos.MERIT.getNombre(), NombresInsumos.MERIT.getDosis());
        administrador.decrementarInsumo(NombresInsumos.NORMOGOTERO.getNombre(), NombresInsumos.NORMOGOTERO.getDosis());
        
        switch (suero) {
            case QUELANTE:
                prepararSueroQuelante(dosisEDTA);
                break;
            case MINERAL:
                prepararSueroMineralizante();
                break;
            default:
                MensajesDeDialogo.mostrarErrorPreparacionSuero();
        }
    }

    private void prepararSueroQuelante(int dosisEDTA) {
        administrador.decrementarInsumo(NombresInsumos.EDTA.getNombre(), dosisEDTA);
    }

    private void prepararSueroMineralizante() {
        administrador.decrementarInsumo(NombresInsumos.MVI.getNombre(), NombresInsumos.MVI.getDosis());
    }

    

}
