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
public class EscritorReportesPaciente {

    private Reporte reporte;
    private final String ENCABEZADO_REPORTE = "Consultorio Dr Miguel Jaime Pat Chuc";
    private final String TITULO_REPORTE = "REPORTE DE PACIENTES";
    
    public EscritorReportesPaciente(String ruta) throws FileNotFoundException, DocumentException{
        reporte = new Reporte(ruta, "Paciente");
    }


    public void llenarReportePaciente(Paciente paciente, Fecha fechaReporte) throws DocumentException {
        reporte.insertarParrafo(ENCABEZADO_REPORTE);
        reporte.insertarParrafo(TITULO_REPORTE);
        reporte.insertarSaltoDeLinea();
        
        reporte.insertarParrafo("Fecha: " + fechaReporte.toString());
        reporte.insertarSaltoDeLinea();
        
        reporte.insertarParrafo("Nombre: " + paciente.getNombres());
        reporte.insertarParrafo("Apellidos: " + paciente.getApellidos());
        reporte.insertarParrafo("Edad: " + paciente.getEdad());

        if (paciente.getTratamiento().getUltimaAplicacion() != null) {
            reporte.insertarParrafo("Número de Aplicaciones: "
                    + paciente.getTratamiento().getUltimaAplicacion().getNumAplicacion());
        } else {
            reporte.insertarParrafo("Numero de Aplicaciones: 0");
        }
        
        reporte.insertarParrafo("Fecha de Inicio: "
                + paciente.getFechaDeInscripcion().toString());

        reporte.insertarSaltoDeLinea();

        reporte.insertarTabla("Enfermedades Previas", paciente.getEnfermedadesPrevias());
        reporte.insertarSaltoDeLinea();
        
        reporte.insertarTabla("Medicamentos", paciente.getMedicamentosExternos());
    }
}
