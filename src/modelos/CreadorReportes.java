/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;






/**
 *
 * @author miguelangel
 */
public class CreadorReportes {
    
    private final String NOMBRE_REPORTE = "src/modelos/Reporte.PDF";
    
    public void crearDocumentoPDF() throws FileNotFoundException, DocumentException{
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        
        ficheroPdf = new FileOutputStream(NOMBRE_REPORTE);
        //PdfCopy copy = new PdfCopy(documento, ficheroPdf);
        
        PdfWriter.getInstance(documento, ficheroPdf);
    }
   
    public static void main(String[] args) {
        CreadorReportes cr = new CreadorReportes();
        try {
            cr.crearDocumentoPDF();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CreadorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
