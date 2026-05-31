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

public class IU_CalcularImpuesto {
    public static void main(String[] args) {
        calcularImpuesto();    
    }
    private static void calcularImpuesto(){
        // 1. Instanciar la venta (se asume que Venta tiene un constructor por defecto o similar)
        Venta venta = new Venta(); 

        // 2. Aplicar Polimorfismo: Elegir una implementación del adaptador
        // En un sistema real, esto podría cargarse dinámicamente o por configuración
        AdaptadorCalculadorDeImpuestos adaptador = new AdaptadorImpuestosPro();
        
        // 3. Crear el controlador inyectando el adaptador (GRASP: Polimorfismo / Fabricación Pura)
        CC_CalcularImpuesto controller = new CC_CalcularImpuesto(adaptador);
        
        // 4. Calcular los impuestos a través del controlador
        List<LineaDeImpuesto> impuestos = controller.calcularImpuestos(venta);
        
        // 5. Mostrar los resultados en la "Interfaz de Usuario"
        System.out.println("--- Reporte de Impuestos ---");
        for (LineaDeImpuesto linea : impuestos) {
            System.out.println("Impuesto: " + linea.getNombre() + " | Monto: " + linea.getMonto());
        }
    }
    
}
