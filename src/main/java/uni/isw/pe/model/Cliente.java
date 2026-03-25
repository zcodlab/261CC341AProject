package uni.isw.pe.model;

import java.sql.Date;

public class Cliente {
    private String dni;
    private String apellidos;
    private String nombre;
    private Date fechaNac;
    private String tfno;

    public Cliente() {
    }

    public Cliente(String dni, String apellidos, String nombre, Date fechaNac, String tfno) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.tfno = tfno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTfno() {
        return tfno;
    }

    public void setTfno(String tfno) {
        this.tfno = tfno;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}
