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
        tomarDatos();
    }
    
    public static RecepcionistaVentanaPaseLista obtenerRecepcionista() {
        if (recepcionista == null) {
            recepcionista = new RecepcionistaVentanaPaseLista();
        }
        recepcionista.ventana.setVisible(true);
        return recepcionista;
    }
    
    public void tomarDatos() {
        ventana.getBotonGuardarCambios().addActionListener((ActionEvent e) -> {
            int COLUMNA_BOLEANA = 6;
            int COLUMNA_ID_PACIENTE = 0;
            for (int iPaciente = 0; iPaciente < ventana.getTablaDeSesiones().getModel().getRowCount(); iPaciente++) {
                
                if ((Boolean) ventana.getTablaDeSesiones().getModel().getValueAt(iPaciente, COLUMNA_BOLEANA)) {
                    
                    mandarAsistencia(ventana.getTablaDeSesiones().getValueAt(iPaciente, COLUMNA_ID_PACIENTE).toString());

                }
                
            }
            actualizarTablaPacientes();
        });
    }

    public void recibirPacientesConCita(ArrayList<Paciente> pacientes) {
        mostrarPacientesConCita(pacientes);
    }

    private void actualizarTablaPacientes() {
        controlador.mandarARecepcionistaPacientesConCita();
    }

    private void mandarAsistencia(String id) {
        controlador.mandarAAsistenteIDPacienteConAsistencia(id);
    }

    private void mostrarPacientesConCita(ArrayList<Paciente> pacientes) {
        int LIMPIAR_FILAS = 0;
        ventana.getModelo().setRowCount(LIMPIAR_FILAS);
        for (Paciente paciente : pacientes) {
            Object datosPaciente[] = {paciente.getId(), paciente.getNombres(), paciente.getApellidos(),
                paciente.getTratamiento().getSiguienteAplicacion().getSuero(),
                paciente.getTratamiento().getDosisEDTA_ml(),
                paciente.getTratamiento().getSiguienteAplicacion().getNumAplicacion(),
                paciente.getTratamiento().getSiguienteAplicacion().isRealizada()};
            ventana.getModelo().addRow(datosPaciente);
        }
    }

    

    
}
