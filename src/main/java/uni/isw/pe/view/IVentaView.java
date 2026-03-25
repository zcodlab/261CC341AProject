package uni.isw.pe.view;

import java.util.List;
import uni.isw.pe.controller.VentaControllerListener;
import uni.isw.pe.model.Cliente;
import uni.isw.pe.model.Producto;

public interface IVentaView {
    void setClientes(List<Cliente> clientes);
    void setProductos(List<Producto> productos);
    void setProximoNumeroVenta(int numero);
    void setPrecioProducto(double precio);
    
    Cliente getClienteSeleccionado();
    Producto getProductoSeleccionado();
    String getCantidad();
    String getDescuento();
    
    void agregarDetalleATabla(int codigo, String descripcion, double pu, int cant, double dscto, double subtotal);
    void setTotal(double total);
    void limpiarVenta(int nuevoNumero);
    
    void mostrarMensaje(String mensaje);
    void mostrarError(String mensaje);
    
    void setListener(VentaControllerListener listener);
}
