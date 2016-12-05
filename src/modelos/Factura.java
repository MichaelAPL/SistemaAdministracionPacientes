
package modelos;

public class Factura {
    
    private Fecha fecha;
    private String descripcion;
    private double monto;
    private int folio;

    public Factura(Fecha fecha, double monto, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public Factura(int folio, Fecha fecha, double monto, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.folio = folio;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public int getFolio() {
        return folio;
    }

    
    
}
