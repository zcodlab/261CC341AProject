package uni.isw.solid;

// 5. Implementación del reporte (OCP):Open/Closed Principle (OCP):
import java.util.List;

public class ReporteServiceImpl implements ReporteService{
    @Override
    public void generarReporte(List<Producto> productos) {
        System.out.println("Reporte de Productos:");
        for (Producto producto : productos) {
            System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
        }
    }
}
