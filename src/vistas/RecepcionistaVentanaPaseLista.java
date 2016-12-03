/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorVentanaPaseLista;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import modelos.Paciente;

/**
 *
 * @author Milka
 */
public class RecepcionistaVentanaPaseLista {

    private static RecepcionistaVentanaPaseLista recepcionista;
    private VentanaPaseLista ventana;
    private ControladorVentanaPaseLista controlador;

    private RecepcionistaVentanaPaseLista() {
        ventana = VentanaPaseLista.obtenerUnicaVentana();
        controlador = ControladorVentanaPaseLista.obtenerControlador();
        tomarAsistencias();
    }
    
    public void recibirPacientesConCita(ArrayList<Paciente> pacientes){
        mostrarPacientesConCita(pacientes);
    }
    
    public static RecepcionistaVentanaPaseLista obtenerRecepcionista(){
        if (recepcionista == null) {
            recepcionista = new RecepcionistaVentanaPaseLista();
        }
        return recepcionista;
    }

    private void mostrarPacientesConCita(ArrayList<Paciente> pacientes) {
        ventana.setVisible(true);
        int LIMPIAR_FILAS = 0;
        ventana.getModelo().setRowCount(LIMPIAR_FILAS);
        for (Paciente paciente : pacientes) {
            Object datosPaciente[] = {paciente.getId(), paciente.getNombres(), paciente.getApellidos(),
                paciente.getTratamiento().getSiguienteAplicacion().getSuero(),
                paciente.getTratamiento().getDosisEDTA(),
                paciente.getTratamiento().getSiguienteAplicacion().getNumAplicacion(),
                false};
            ventana.getModelo().addRow(datosPaciente);
        }
    }

    public void tomarAsistencias() {
        ventana.getBotonGuardarCambios().addActionListener((ActionEvent e) -> {
            for (int i = 0; i < ventana.getTablaDeSesiones().getModel().getRowCount(); i++) {
                if ((Boolean) ventana.getTablaDeSesiones().getModel().getValueAt(i, 6) == true) {
                    mandarAsistencia(ventana.getTablaDeSesiones().getValueAt(i, 0).toString());
                }
                actualizarTablaPacientes();
            }
        });
    }
    
    private void mandarAsistencia(String id){
        controlador.mandarAAsistenteIDPacienteConAsistencia(id);
    }
    
    private void actualizarTablaPacientes(){
        controlador.mandarARecepcionistaPacientesConCita();
    }
}
