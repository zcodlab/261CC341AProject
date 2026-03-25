package uni.isw.pe.model;

public class Proveedor {
    private String ruc;
    private String empresa;
    private String direccion;

    public Proveedor() {
    }

    public Proveedor(String ruc, String empresa, String direccion) {
        this.ruc = ruc;
        this.empresa = empresa;
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return empresa;
    }
}
