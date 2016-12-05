/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author miguelangel
 */
public class EscritorReporteInventario {
    private Document documento;
    private final String NOMBRE_REPORTE = "/Reporte.pdf";
    private final int INTERLINEADO = 20;

    private final String ENCABEZADO_REPORTE = "Consultorio Dr Miguel Jaime Pat Chuc";
    private final String TITULO_REPORTE = "REPORTE DE INGRESOS";
    
    public EscritorReporteInventario(String ruta) throws FileNotFoundException, DocumentException{
        crearReporte(ruta);
    }

    private void crearReporte(String ruta) throws FileNotFoundException, DocumentException {
        documento = new Document();
        FileOutputStream ficheroPdf;

        ficheroPdf = new FileOutputStream(ruta + NOMBRE_REPORTE);

        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(INTERLINEADO);
    }
    
    public void llenarReporte() throws DocumentException{                
        documento.open();
        documento.add(new Paragraph(ENCABEZADO_REPORTE));
        documento.add(new Paragraph(TITULO_REPORTE));
        
        
        documento.close();
    }
}
