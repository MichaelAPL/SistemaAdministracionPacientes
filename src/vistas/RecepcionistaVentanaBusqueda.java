/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorBusqueda;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelos.Paciente;

/**
 *
 * @author Milka
 */
public class RecepcionistaVentanaBusqueda {

    private static RecepcionistaVentanaBusqueda recepcionista;
    private VentanaBusqueda ventana;
    private ControladorBusqueda controlador;

    private RecepcionistaVentanaBusqueda() {
        ventana = VentanaBusqueda.obtenerVentana();
        controlador = ControladorBusqueda.obtenerControlador();
        tomarDatos();

    }

    public static RecepcionistaVentanaBusqueda obtenerRecepcionista() {
        if (recepcionista == null) {
            recepcionista = new RecepcionistaVentanaBusqueda();
        }
        recepcionista.ventana.setVisible(true);
        return recepcionista;
    }

    public void tomarDatos() {
        ventana.getBotonIr().addActionListener((ActionEvent e) -> {
            if (ventana.getListaPacientes().getSelectedValue() != null) {
                String separadorID_Nonmbre = ":";
                String[] texto = String.valueOf(ventana.getListaPacientes().getSelectedValue()).split(separadorID_Nonmbre);
                String idPacienteSeleccionado = texto[0];
                controlador.recibirIDPaciente(idPacienteSeleccionado);
            }
            limpiarCampos();
            ventana.dispose();
        });

        ventana.getBotonBuscar().addActionListener((ActionEvent e) -> {
            if (ventana.getNombresPaciente().getText() != null) {
                controlador.mandarARecepcionistaPacientesEncontrados(ventana.getNombresPaciente().getText());
            }
        });
    }

    public void mostrarPacientes(ArrayList<Paciente> pacientes) {
        String[] nombresPacientes = new String[pacientes.size()];
        String separadorID_Nonmbre = ":";
        String espacio = " ";
        for (int i = 0; i < pacientes.size(); i++) {
            nombresPacientes[i] = pacientes.get(i).getId() + separadorID_Nonmbre
                    + pacientes.get(i).getNombres() + espacio + pacientes.get(i).getApellidos();
        }

        ventana.getListaPacientes().setListData(nombresPacientes);
    }
    
    private void limpiarCampos(){
        this.ventana.getNombresPaciente().setText("");
        String[] listaVacia = {"", "", ""};
        this.ventana.getListaPacientes().repaint();
    }
}
