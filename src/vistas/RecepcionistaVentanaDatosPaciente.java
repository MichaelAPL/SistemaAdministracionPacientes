
package vistas;

import com.itextpdf.text.DocumentException;
import controladores.ControladorDatosPaciente;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import modelos.EscritorReportesPaciente;
import modelos.Fecha;
import modelos.MensajesDeDialogo;
import modelos.Paciente;

/**
 *
 * @author Milka
 */
public class RecepcionistaVentanaDatosPaciente {

    private static RecepcionistaVentanaDatosPaciente recepcionista;
    private VentanaDatosPaciente ventana;
    private ControladorDatosPaciente controlador;
    private Paciente paciente;
    private EscritorReportesPaciente creadorReportes;
    private final String espacioVacio = "";

    private RecepcionistaVentanaDatosPaciente() {
        ventana = VentanaDatosPaciente.obtenerVentana();
        controlador = ControladorDatosPaciente.obtenerControlador();
        modificarDatos();
    }

    public static RecepcionistaVentanaDatosPaciente obtenerRecepcionista() {
        if (recepcionista == null) {
            recepcionista = new RecepcionistaVentanaDatosPaciente();
        }
        recepcionista.ventana.setVisible(true);
        return recepcionista;
    }

    public void modificarDatos() {
        ventana.getModificarDatos().addActionListener((ActionEvent e) -> {
            mandarModificaciones();
        });

        ventana.getEliminarEnfermedad().addActionListener((ActionEvent e) -> {
            if (ventana.getTablaEnfermedadesPaciente().getSelectedValue() != null) {
                paciente.eliminarEnfermedad(String.valueOf(ventana.getTablaEnfermedadesPaciente().getSelectedValue()));
            }
            mostrarEnfermedades(paciente.getEnfermedadesPrevias());
        });

        ventana.getEliminarMedicamento().addActionListener((ActionEvent e) -> {
            if (ventana.getTablaMedicamentosPaciente().getSelectedValue() != null) {
                paciente.eliminarMedicamento(String.valueOf(ventana.getTablaMedicamentosPaciente().getSelectedValue()));
            }
            mostrarMedicamentos(paciente.getMedicamentosExternos());
        });

        ventana.getInsertarEnfermedad().addActionListener((ActionEvent e) -> {
            if (ventana.getEnfermedadNueva().getText() != null) {
                paciente.insertarEnfermedad(ventana.getEnfermedadNueva().getText());
                ventana.getEnfermedadNueva().setText(espacioVacio);
            }
            mostrarEnfermedades(paciente.getEnfermedadesPrevias());
        });

        ventana.getInsertarMedicamento().addActionListener((ActionEvent e) -> {
            if (ventana.getMedicamentoNuevo().getText() != null) {
                paciente.insertarMedicamento(ventana.getMedicamentoNuevo().getText());
                ventana.getMedicamentoNuevo().setText(espacioVacio);
            }
            mostrarMedicamentos(paciente.getMedicamentosExternos());
        });
        
        ventana.getGenerarReoporte().addActionListener((ActionEvent e) ->{
            ExploradorArchivos exploradorArchivos = 
                    new ExploradorArchivos("Seleccione donde guardará el reporte");                        
            
            Fecha fechaDelReporte = new Fecha();
            try {
                creadorReportes = new EscritorReportesPaciente(exploradorArchivos.getRuta());
                creadorReportes.llenarReportePaciente(paciente, fechaDelReporte);
            } catch (DocumentException ex) {
                MensajesDeDialogo.mostrarErrorAlCrearReportePaciente();
            } catch (FileNotFoundException ex) {
                MensajesDeDialogo.ErrorRutaInvalida();
            }
        });

    }

    public void mostrarDatosPaciente(Paciente paciente) {
        this.paciente = paciente;
        ventana.getNombresPaciente().setText(paciente.getNombres());
        ventana.getApellidosPaciente().setText(paciente.getApellidos());
        ventana.getLocalidadPaciente().setText(paciente.getLocalidad());
        ventana.getEdadPaciente().setText(String.valueOf(paciente.getEdad()));
        ventana.getDireccionPaciente().setText(paciente.getDireccion());
        ventana.getDosisEDTApaciente().setText(String.valueOf(paciente.getTratamiento().getDosisEDTA_ml()));
        ventana.getTelefonoPaciente().setText(paciente.getTelefono());

        mostrarEnfermedades(paciente.getEnfermedadesPrevias());
        mostrarMedicamentos(paciente.getMedicamentosExternos());
    }
    
    private void mandarModificaciones() {
        paciente.setNombres(ventana.getNombresPaciente().getText());
        paciente.setApellidos(ventana.getApellidosPaciente().getText());
        paciente.setDireccion(ventana.getDireccionPaciente().getText());
        paciente.setEdad(Integer.valueOf(ventana.getEdadPaciente().getText()));
        paciente.setLocalidad(ventana.getLocalidadPaciente().getText());
        paciente.setTelefono(ventana.getTelefonoPaciente().getText());
        paciente.getTratamiento().setDosisEDTA_ml(Integer.valueOf(ventana.getDosisEDTApaciente().getText()));

        controlador.mandarAAsistenteDatosPacienteAActualizar(paciente);
    }

    private void mostrarEnfermedades(ArrayList<String> enfermedadesPrevias) {
        Object[] enfermedades = new String[enfermedadesPrevias.size()];
        enfermedades = enfermedadesPrevias.toArray(enfermedades);
        ventana.getTablaEnfermedadesPaciente().setListData(enfermedades);
    }

    private void mostrarMedicamentos(ArrayList<String> medicamentosExternos) {
        Object[] medicamentos = new String[medicamentosExternos.size()];
        medicamentos = medicamentosExternos.toArray(medicamentos);
        ventana.getTablaMedicamentosPaciente().setListData(medicamentos);
    }
}
