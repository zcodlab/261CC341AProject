package uni.isw.grasp.polimorfismo;

import java.util.ArrayList;
import java.util.List;
import uni.isw.tpdv.model.Venta;

public class AdaptadorImpuestosPro implements AdaptadorCalculadorDeImpuestos {

    @Override
    public List<LineaDeImpuesto> getImpuestos(Venta venta) {
        List<LineaDeImpuesto> impuestos = new ArrayList<>();
        // En una implementación real, se usaría 'venta' para calcular los montos
        impuestos.add(new LineaDeImpuesto("IGV (18%)", 18.0));
        impuestos.add(new LineaDeImpuesto("Impuesto Pro", 5.0));
        return impuestos;
    }
    
}
