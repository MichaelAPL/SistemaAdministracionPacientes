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
public class Reporte {
    private Document reporte;
    
    public Reporte(String ruta, String nombre) throws FileNotFoundException, DocumentException{
        crearReporte(ruta, nombre);
    }

    private void crearReporte(String ruta, String nombre) throws FileNotFoundException, DocumentException {
        String NOMBRE_REPORTE = "/" + nombre + "Reporte.pdf";
        int interlineado = 20;
        reporte = new Document();
        FileOutputStream ficheroPdf;

        ficheroPdf = new FileOutputStream(ruta + NOMBRE_REPORTE);

        PdfWriter.getInstance(reporte, ficheroPdf).setInitialLeading(interlineado);
    }
    
    public void abrirReporte(){
        reporte.open();
    }
    
    public void cerrarReporte(){
        reporte.close();
    }
    
    public void insertarParrafo(String texto) throws DocumentException{
        Paragraph paragraph = new Paragraph("texto");
        reporte.add(paragraph);
    }
    
    public void insertarSaltoDeLinea() throws DocumentException{
        Paragraph paragraph = new Paragraph(" ");
        reporte.add(paragraph);
    }
    
    public void insertarTabla(String titulo, ArrayList datos) throws DocumentException{
        PdfPTable tabla = new PdfPTable(1);
        tabla.addCell(titulo);
        for (int i = 0; i < datos.size(); i++) {
            tabla.addCell((String)datos.get(i));
        }
        reporte.add(tabla);
        insertarSaltoDeLinea();
    }
}
