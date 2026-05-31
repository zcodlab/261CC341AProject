package uni.isw.grasp.polimorfismo;

import java.util.ArrayList;
import java.util.List;
import uni.isw.tpdv.model.Venta;

public class AdaptadorMasterEnImpuestos implements AdaptadorCalculadorDeImpuestos{

    @Override
    public List<LineaDeImpuesto> getImpuestos(Venta venta) {
        List<LineaDeImpuesto> impuestos = new ArrayList<>();
        // Otra lógica de cálculo diferente
        impuestos.add(new LineaDeImpuesto("IGV (18%)", 18.0));
        impuestos.add(new LineaDeImpuesto("Impuesto Master", 10.0));
        impuestos.add(new LineaDeImpuesto("Tasa Municipal", 2.5));
        return impuestos;
    }
    
}
