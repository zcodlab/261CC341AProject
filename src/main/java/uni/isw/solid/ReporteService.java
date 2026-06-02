package uni.isw.solid;
// 4. Interfaz para el reporte (ISP):Interface Segregation Principle (ISP)

import java.util.List;

public interface ReporteService {
    void generarReporte(List<Producto> productos);
}
