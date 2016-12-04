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

    public void recibirPacientesConCita(ArrayList<Paciente> pacientes) {
        mostrarPacientesConCita(pacientes);
    }

    public void mostrarPacientesConCita(ArrayList<Paciente> pacientes) {
        int LIMPIAR_FILAS = 0;
        ventana.getModelo().setRowCount(LIMPIAR_FILAS);
        for (Paciente paciente : pacientes) {
            Object datosPaciente[] = {paciente.getId(), paciente.getNombres(), paciente.getApellidos(),
                paciente.getTratamiento().getSiguienteAplicacion().getSuero(),
                paciente.getTratamiento().getDosisEDTA(),
                paciente.getTratamiento().getSiguienteAplicacion().getNumAplicacion(),
                paciente.getTratamiento().getSiguienteAplicacion().isRealizada()};
            ventana.getModelo().addRow(datosPaciente);
        }
    }

    public void tomarDatos() {
        ventana.getBotonGuardarCambios().addActionListener((ActionEvent e) -> {
            for (int i = 0; i < ventana.getTablaDeSesiones().getModel().getRowCount(); i++) {
                
                if ((Boolean) ventana.getTablaDeSesiones().getModel().getValueAt(i, 6)) {
                    
                    mandarAsistencia(ventana.getTablaDeSesiones().getValueAt(i, 0).toString());

                }
                
            }
            actualizarTablaPacientes();
        });
    }

    public static RecepcionistaVentanaPaseLista obtenerRecepcionista() {
        if (recepcionista == null) {
            recepcionista = new RecepcionistaVentanaPaseLista();
        }
        recepcionista.ventana.setVisible(true);
        return recepcionista;
    }

    public void mandarAsistencia(String id) {
        controlador.mandarAAsistenteIDPacienteConAsistencia(id);
    }

    public void actualizarTablaPacientes() {
        controlador.mandarARecepcionistaPacientesConCita();
    }
}
