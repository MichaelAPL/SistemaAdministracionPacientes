/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.DAOs.FacturaDAO;

/**
 *
 * @author miguelangel
 */
public class EscritorReporteInventario {
    private Reporte reporte;
    private final String ENCABEZADO_REPORTE = "Consultorio Dr Miguel Jaime Pat Chuc";
    private final String TITULO_REPORTE = "REPORTE DE INVENTARIO";
    
    //private AdministradorInventario administrador;
    private FacturaDAO facturaDAO;
    
    public EscritorReporteInventario(String ruta) throws FileNotFoundException, DocumentException{
        reporte = new Reporte(ruta, "Inventario");
        facturaDAO = new FacturaDAO();
        //administrador = AdministradorInventario.obtenerUnicoAdministradorInventario();
    }
    
    public void llenarReporteInventario(int mes, int año) throws DocumentException, SQLException{
        reporte.abrirReporte();
        
        reporte.insertarParrafo(ENCABEZADO_REPORTE);
        reporte.insertarParrafo(TITULO_REPORTE);
        reporte.insertarSaltoDeLinea();
        
        ArrayList<Factura> facturas;
        facturas = facturaDAO.recuperarFacturasMes(mes, año);
        
        for (int i = 0; i < facturas.size(); i++) {
            reporte.insertarParrafo(facturas.get(i).getDescripcion());
        }
        
        reporte.cerrarReporte();
    }
}
