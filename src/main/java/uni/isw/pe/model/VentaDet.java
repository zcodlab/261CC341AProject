package uni.isw.pe.model;

public class VentaDet {
    private int numero;
    private int codigo;
    private double pu;
    private double dscto;
    private int cantidad;
    private double subtotal;

    public VentaDet() {
    }

    public VentaDet(int numero, int codigo, double pu, double dscto, int cantidad, double subtotal) {
        this.numero = numero;
        this.codigo = codigo;
        this.pu = pu;
        this.dscto = dscto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    public double getDscto() {
        return dscto;
    }

    public void setDscto(double dscto) {
        this.dscto = dscto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
