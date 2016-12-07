/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorRegistro;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.MensajesDeDialogo;
import modelos.Paciente;
import modelos.Persona;
import modelos.Tratamiento;

/**
 *
 * @author Milka
 */
public class RecepcionistaVentanaRegistroPaciente {

    private static RecepcionistaVentanaRegistroPaciente recepcionista;
    private VentanaRegistroPaciente ventana;
    private ControladorRegistro controlador;
    private ArrayList<String> enfermedadesPrevias;
    private ArrayList<String> medicamentosExternos;

    private RecepcionistaVentanaRegistroPaciente() {
        ventana = VentanaRegistroPaciente.obtenerUnicaVentana();
        controlador = ControladorRegistro.obtenerControlador();
        enfermedadesPrevias = new ArrayList();
        medicamentosExternos = new ArrayList();
        tomarDatos();
    }

    public static RecepcionistaVentanaRegistroPaciente obtenerRecepcionista() {
        if (recepcionista == null) {
            recepcionista = new RecepcionistaVentanaRegistroPaciente();
        }
        recepcionista.ventana.setVisible(true);
        return recepcionista;
    }

    public void tomarDatos() {

        ventana.getBotonGuardar().addActionListener((ActionEvent e) -> {
            try {
                Persona persona = new Persona(ventana.getNombres().getText(), 
                    ventana.getApellidos().getText(),ventana.getDireccion().getText(), 
                    ventana.getLocalidad().getText(),ventana.getTelefono().getText(), 
                    Integer.parseInt(ventana.getEdad().getText()));

                Tratamiento tratamiento = new Tratamiento
                    (Integer.parseInt(ventana.getEDTA().getText()));

                Paciente paciente = new Paciente(persona, medicamentosExternos, 
                     enfermedadesPrevias, tratamiento);

                controlador.mandarAAsistenteNuevoPaciente(paciente);
                MensajesDeDialogo.mostrarMensajeDatosGuardadosExitosamente();
                ventana.dispose();
                ventana.limpiarVentana();
            } catch (Exception ex) {
                MensajesDeDialogo.mostrarErrorDatosEntradaIncorrectos();
            }

        });

        ventana.getjEliminarEnfermedad().addActionListener((ActionEvent e) -> {
            eliminarEnfermedad(ventana.getTablaPadecimientos());
        });

        ventana.getjEliminarMedicamento().addActionListener((ActionEvent e) -> {
            eliminarMedicamento(ventana.getTablaMedicamentos());
        });

        ventana.getAñadirMedicamento().addActionListener((ActionEvent e) -> {
            if (!ventana.getMedicamento().getText().equals("")) {
                this.medicamentosExternos.add(ventana.getMedicamento().getText());
                actualizarDatosTabla(ventana.getTablaMedicamentos(), this.medicamentosExternos);
                ventana.getMedicamento().setText("");
            }
        });

        ventana.getAñadirEnfermedad().addActionListener((ActionEvent e) -> {
            if (!ventana.getPadecimiento().getText().equals("")) {
                this.enfermedadesPrevias.add(ventana.getPadecimiento().getText());
                actualizarDatosTabla(ventana.getTablaPadecimientos(), this.enfermedadesPrevias);
                ventana.getPadecimiento().setText("");
            }
        });
    }

    private void actualizarDatosTabla(JTable tabla, ArrayList<String> datos) {
        int iNombreEncabezado = 0;
        int iColumna = 0;
        String cabecera[] = {tabla.getColumnName(iNombreEncabezado)};
        String[][] cuerpo = new String[datos.size()][1];
        for (int iDato = 0; iDato < datos.size(); iDato++) {
            cuerpo[iDato][iColumna] = datos.get(iDato);
        }
        DefaultTableModel modelo = new DefaultTableModel(cuerpo, cabecera);
        tabla.setModel(modelo);
    }

    private void eliminarEnfermedad(JTable tabla) {
        this.enfermedadesPrevias.remove(tabla.getSelectedRow());
        actualizarDatosTabla(tabla, this.enfermedadesPrevias);
    }

    private void eliminarMedicamento(JTable tabla) {
        this.medicamentosExternos.remove(tabla.getSelectedRow());
        actualizarDatosTabla(tabla, this.medicamentosExternos);
    }

}
