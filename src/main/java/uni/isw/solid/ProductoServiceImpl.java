package uni.isw.solid;
// 3. Implementación del servicio de productos (OCP):Open/Closed Principle (OCP):

import java.util.ArrayList;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{

    private List<Producto> productos = new ArrayList<>();

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return productos;
    }
    
}
