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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.DAOs.PacienteDAO;






/**
 *
 * @author miguelangel
 */
public class CreadorReportes {
    private Document documento;
    private final String RUTA_REPORTE = "src/modelos/Reporte ";
    private final int INTERLINEADO = 20;
    
    private final String ENCABEZADO_REPORTE = "Consultorio Dr Miguel Jaime Pat Chuc";
    private final String TITULO_REPORTE = "REPORTE DE PACIENTES";
    
    public void crearReporte(Fecha fechaReporte, ArrayList<Paciente> pacientes) throws FileNotFoundException, DocumentException{
        documento = new Document();
        FileOutputStream ficheroPdf;
        
        ficheroPdf = new FileOutputStream(RUTA_REPORTE + ".pdf");
        
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(INTERLINEADO);
        this.llenarReportePacientesActivos(documento, fechaReporte, pacientes);
    }

    private void llenarReportePacientesActivos(Document documento, 
            Fecha fechaReporte, ArrayList<Paciente> pacientes) throws DocumentException {
        documento.open();
        
        documento.add(new Paragraph(ENCABEZADO_REPORTE));
        documento.add(new Paragraph(TITULO_REPORTE));
        documento.add(new Paragraph("Fecha: " + fechaReporte.toString()));
        
        Paragraph espacioEnBlanco = new Paragraph(" ");
        Paragraph nombre;
        Paragraph apellidos;
        Paragraph edad;
        Paragraph numAplicaciones;
        Paragraph fechaInicio;
        
        for (int i = 0; i < pacientes.size(); i++) {
            nombre = new Paragraph("Nombre: " + pacientes.get(i).getNombres());
            apellidos = new Paragraph("Apellidos: " + pacientes.get(i).getApellidos());
            edad = new Paragraph("Edad: " + pacientes.get(i).getEdad());
            //numAplicaciones = new Paragraph("Número de Aplicaciones :" + 
            //        pacientes.get(i).getTratamiento().getUltimaAplicacion().getNumAplicacion());
            fechaInicio = new Paragraph("Fecha de Inicio: " + 
                    pacientes.get(i).getFechaDeInscripcion().toString());
            
            documento.add(nombre);
            documento.add(apellidos);
            documento.add(edad);
            //documento.add(numAplicaciones);
            documento.add(fechaInicio);
            documento.add(espacioEnBlanco);
            
            
            PdfPTable tablaEnfermedades = new PdfPTable(1);
            tablaEnfermedades.addCell("Enfermedades Previas");
            for (int j = 0; j < pacientes.get(i).getEnfermedadesPrevias().size(); j++){
                tablaEnfermedades.addCell(pacientes.get(i).getEnfermedadesPrevias().get(j));
            }
            documento.add(tablaEnfermedades);
            documento.add(espacioEnBlanco);
            
            PdfPTable tablaMedicamentos = new PdfPTable(1);
            tablaMedicamentos.addCell("Medicamentos");
            for (int j = 0; j < pacientes.get(i).getMedicamentosExternos().size(); j++){
                tablaMedicamentos.addCell(pacientes.get(i).getMedicamentosExternos().get(j));
            }
            documento.add(tablaMedicamentos);
            documento.add(espacioEnBlanco);
        }
       
        documento.close();
    }
    
    public static void main(String[] args) {
        PacienteDAO dao = new PacienteDAO();
        
        CreadorReportes cr = new CreadorReportes();
        Fecha hoy = new Fecha();
        try {
            ArrayList<Paciente> pacientes = dao.recuperarTodos();
            cr.crearReporte(hoy, pacientes);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CreadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
