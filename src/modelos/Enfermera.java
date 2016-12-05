package modelos;

import modelos.enums.NombresInsumos;
import modelos.enums.Suero;

/**
 *
 * @author Milka
 */
public class Enfermera {

    private static Enfermera enfermera;
    private AdministradorInventario administrador;

    private Enfermera() {
        administrador = AdministradorInventario.obtenerUnicoAdministradorInventario();
    }

    public static Enfermera llamarEnfermera() {
        if (enfermera == null) {
            enfermera = new Enfermera();
        }
        return enfermera;
    }
    
    public void atenderPaciente(Paciente paciente){
        
        prepararSuero(paciente.getTratamiento().getSiguienteAplicacion().getSuero()
            , paciente.getTratamiento().getDosis_EDTA_ml());
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
