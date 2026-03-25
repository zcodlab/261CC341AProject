package uni.isw.pe.model;

public class Producto {
    private int codigo;
    private String ruc;
    private String descripcion;
    private double precio;

    public Producto() {
    }

    public Producto(int codigo, String ruc, String descripcion, double precio) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
