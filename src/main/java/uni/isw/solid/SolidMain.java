package uni.isw.solid;

import java.util.List;
// 6. Clase principal que implementa DIP: Dependency Inversion Principle (DIP)
public class SolidMain {
    public static void main(String[] args) {
        ProductoService productoService = new ProductoServiceImpl();
        ReporteService reporteService = new ReporteServiceImpl();

        // Agregar productos
        productoService.agregarProducto(new Producto("Laptop", 1000.0));
        productoService.agregarProducto(new Producto("Smartphone", 500.0));
        productoService.agregarProducto(new Producto("Tableta", 300.0));

        // Generar reporte
        List<Producto> productos = productoService.obtenerProductos();
        reporteService.generarReporte(productos);
    }
}
