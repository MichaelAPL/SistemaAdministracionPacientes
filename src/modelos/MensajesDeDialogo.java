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
<<<<<<< HEAD

    public static void mostrarErrorDatosEntradaIncorrectos() {
        JOptionPane.showMessageDialog(null, "Algun dato no ha sido llenado",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mostrarErrorAlCrearReportePaciente(){
        JOptionPane.showMessageDialog(null, "Error al momento de crear el reporte",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void ErrorRutaInvalida(){
        JOptionPane.showMessageDialog(null, "Ruta o Dirección no valida",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
=======
>>>>>>> 6d58b2a27d66b6a6c495b480ea10bc0a418dbe14
}
