package uni.isw.solid;
// 2. Interfaz para el servicio de productos (ISP):Interface Segregation Principle (ISP):

import java.util.List;

public interface ProductoService {
    void agregarProducto(Producto producto);
    List<Producto> obtenerProductos();
}
