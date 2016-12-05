/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.swing.JOptionPane;
import vistas.VentanaInventario;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class MensajesDeDialogo {

    public MensajesDeDialogo() {
    }

    public static void errorConLaBD() {
        JOptionPane.showMessageDialog(null, "No ha sido posible conectarse a "
                + "la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarErrorPreparacionSuero() {
        JOptionPane.showMessageDialog(null, "Hubo un error al disminuir los insumos",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarErrorNoSeEncuentraInsumo() {
        JOptionPane.showMessageDialog(null, "Hubo un error al disminuir los insumos",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarErrorDatosEntradaIncorrectos() {
        JOptionPane.showMessageDialog(null, "Algun dato no ha sido llenado",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
