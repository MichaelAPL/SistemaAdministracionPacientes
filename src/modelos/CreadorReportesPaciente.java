/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author miguelangel
 */
public class CreadorReportesPaciente {

    private Document documento;
    private final String NOMBRE_REPORTE = "/Reporte.pdf";
    private final int INTERLINEADO = 20;

    private final String ENCABEZADO_REPORTE = "Consultorio Dr Miguel Jaime Pat Chuc";
    private final String TITULO_REPORTE = "REPORTE DE PACIENTES";
    
    public CreadorReportesPaciente(String ruta) throws FileNotFoundException, DocumentException{
        crearReporte(ruta);
    }

    private void crearReporte(String ruta) throws FileNotFoundException, DocumentException {
        documento = new Document();
        FileOutputStream ficheroPdf;

        ficheroPdf = new FileOutputStream(ruta +NOMBRE_REPORTE);

        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(INTERLINEADO);
    }

    public void llenarReportePaciente(Paciente paciente, Fecha fechaReporte) throws DocumentException {
        documento.open();

        Paragraph espacioEnBlanco = new Paragraph(" ");
        Paragraph nombre;
        Paragraph apellidos;
        Paragraph edad;
        Paragraph numAplicaciones;
        Paragraph fechaInicio;

        documento.add(new Paragraph(ENCABEZADO_REPORTE));
        documento.add(new Paragraph(TITULO_REPORTE));
        documento.add(new Paragraph("Fecha: " + fechaReporte.toString()));
        documento.add(espacioEnBlanco);

        nombre = new Paragraph("Nombre: " + paciente.getNombres());
        apellidos = new Paragraph("Apellidos: " + paciente.getApellidos());
        edad = new Paragraph("Edad: " + paciente.getEdad());

        if (paciente.getTratamiento().getUltimaAplicacion() != null) {
            numAplicaciones = new Paragraph("Número de Aplicaciones: "
                    + paciente.getTratamiento().getUltimaAplicacion().getNumAplicacion());
        } else {
            numAplicaciones = new Paragraph("Numero de Aplicaciones: 0");
        }

        fechaInicio = new Paragraph("Fecha de Inicio: "
                + paciente.getFechaDeInscripcion().toString());

        documento.add(nombre);
        documento.add(apellidos);
        documento.add(edad);
        documento.add(numAplicaciones);
        documento.add(fechaInicio);
        documento.add(espacioEnBlanco);

        PdfPTable tablaEnfermedades = new PdfPTable(1);
        tablaEnfermedades.addCell("Enfermedades Previas");
        for (int j = 0; j < paciente.getEnfermedadesPrevias().size(); j++) {
            tablaEnfermedades.addCell(paciente.getEnfermedadesPrevias().get(j));
        }
        documento.add(tablaEnfermedades);
        documento.add(espacioEnBlanco);

        PdfPTable tablaMedicamentos = new PdfPTable(1);
        tablaMedicamentos.addCell("Medicamentos");
        for (int j = 0; j < paciente.getMedicamentosExternos().size(); j++) {
            tablaMedicamentos.addCell(paciente.getMedicamentosExternos().get(j));
        }
        
        documento.add(tablaMedicamentos);
        documento.add(espacioEnBlanco);
        
        documento.close();
    }

    public void llenarReportePacientesActivos(Fecha fechaReporte,
            ArrayList<Paciente> pacientes) throws DocumentException {
        
        documento.open();

        Paragraph espacioEnBlanco = new Paragraph(" ");
        Paragraph nombre;
        Paragraph apellidos;
        Paragraph edad;
        Paragraph numAplicaciones;
        Paragraph fechaInicio;

        documento.add(new Paragraph(ENCABEZADO_REPORTE));
        documento.add(new Paragraph(TITULO_REPORTE));
        documento.add(new Paragraph("Fecha: " + fechaReporte.toString()));
        documento.add(espacioEnBlanco);

        for (int i = 0; i < pacientes.size(); i++) {
            nombre = new Paragraph("Nombre: " + pacientes.get(i).getNombres());
            apellidos = new Paragraph("Apellidos: " + pacientes.get(i).getApellidos());
            edad = new Paragraph("Edad: " + pacientes.get(i).getEdad());

            if (pacientes.get(i).getTratamiento().getUltimaAplicacion() != null) {
                numAplicaciones = new Paragraph("Número de Aplicaciones: "
                        + pacientes.get(i).getTratamiento().getUltimaAplicacion().getNumAplicacion());
            } else {
                numAplicaciones = new Paragraph("Numero de Aplicaciones: 0");
            }

            fechaInicio = new Paragraph("Fecha de Inicio: "
                    + pacientes.get(i).getFechaDeInscripcion().toString());

            documento.add(nombre);
            documento.add(apellidos);
            documento.add(edad);
            documento.add(numAplicaciones);
            documento.add(fechaInicio);
            documento.add(espacioEnBlanco);

            PdfPTable tablaEnfermedades = new PdfPTable(1);
            tablaEnfermedades.addCell("Enfermedades Previas");
            for (int j = 0; j < pacientes.get(i).getEnfermedadesPrevias().size(); j++) {
                tablaEnfermedades.addCell(pacientes.get(i).getEnfermedadesPrevias().get(j));
            }
            documento.add(tablaEnfermedades);
            documento.add(espacioEnBlanco);

            PdfPTable tablaMedicamentos = new PdfPTable(1);
            tablaMedicamentos.addCell("Medicamentos");
            for (int j = 0; j < pacientes.get(i).getMedicamentosExternos().size(); j++) {
                tablaMedicamentos.addCell(pacientes.get(i).getMedicamentosExternos().get(j));
            }
            documento.add(tablaMedicamentos);
            documento.add(espacioEnBlanco);
        }

        documento.close();
    }
}
