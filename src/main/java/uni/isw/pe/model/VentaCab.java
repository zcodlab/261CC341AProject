package uni.isw.pe.model;

import java.sql.Date;

public class VentaCab {
    private int numero;
    private Date fecha;
    private String dni;

    public VentaCab() {
    }

    public VentaCab(int numero, Date fecha, String dni) {
        this.numero = numero;
        this.fecha = fecha;
        this.dni = dni;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
