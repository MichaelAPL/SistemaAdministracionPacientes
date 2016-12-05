
package modelos;

import java.util.Date;

public class Fecha {

    private final Date fecha;
    private final int dia;
    private final int mes;
    private final int año;

    public Fecha(int dia, int mes, int año) {
        fecha = new Date();
        fecha.setDate(dia);
        fecha.setMonth(mes - 1);
        fecha.setYear(año - 1900);
        this.dia = fecha.getDate();
        this.mes = fecha.getMonth() + 1;
        this.año = configurarAño(fecha.getYear());
    }

    public Fecha(Date date) {
        fecha = date;
        dia = date.getDate();
        mes = date.getMonth() + 1;
        año = configurarAño(date.getYear());
    }

    public Fecha() {
        fecha = new Date();
        dia = fecha.getDate();
        mes = fecha.getMonth() + 1;
        año = configurarAño(fecha.getYear());
    }

    public long getTime() {
        return fecha.getTime();
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + año;
    }

    public boolean comperTo(Fecha fecha) {
        return ((fecha.dia == dia) && (fecha.mes == mes) && (fecha.año == año));
    }

    private int configurarAño(int año) {
        int añoModificado = año + 1900;
        return añoModificado;
    }
}
