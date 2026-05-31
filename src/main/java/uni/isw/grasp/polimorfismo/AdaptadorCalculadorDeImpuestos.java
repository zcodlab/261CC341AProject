package uni.isw.grasp.polimorfismo;

import java.util.List;
import uni.isw.tpdv.model.Venta;

public interface AdaptadorCalculadorDeImpuestos {
    public List<LineaDeImpuesto> getImpuestos(Venta venta);
}
