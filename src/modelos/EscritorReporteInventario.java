/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;

/**
 *
 * @author miguelangel
 */
public class EscritorReporteInventario {
    private Reporte reporte;
    
    public EscritorReporteInventario(String ruta) throws FileNotFoundException, DocumentException{
        this.reporte = new Reporte(ruta, "Contabilidad");
    }
    
    public void llenarReporte(){
        
    }
}
