/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.isw.grasp.polimorfismo;

/**
 *
 * @author HP
 */
import java.util.List;
import uni.isw.tpdv.model.Venta;

public class CC_CalcularImpuesto {
    private AdaptadorCalculadorDeImpuestos adaptador;

    public CC_CalcularImpuesto(AdaptadorCalculadorDeImpuestos adaptador) {
        this.adaptador = adaptador;
    }

    public List<LineaDeImpuesto> calcularImpuestos(Venta venta) {
        return adaptador.getImpuestos(venta);
    }
}
