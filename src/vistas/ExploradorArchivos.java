/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JFileChooser;

/**
 *
 * @author miguelangel
 */
public class ExploradorArchivos {

    private JFileChooser explorador;
    private String ruta;

    public ExploradorArchivos(String titulo) {
        explorador = new JFileChooser();
        explorador.setDialogTitle(titulo);
        explorador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = explorador.showDialog(null, "Abrir");
        ruta = "";
        switch (seleccion) {
            case JFileChooser.APPROVE_OPTION:
                ruta = explorador.getSelectedFile().getPath();
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
            case JFileChooser.ERROR_OPTION:
                break;
        }
    }
    
    public String getRuta(){
        return this.ruta;
    }
}
