package uni.isw.designpatterns.decorator.bebida;

public class Cafe implements Bebida {
    @Override
    public String getDescripcion() {
        return "Café";
    }

    @Override
    public double costo() {
        return 2.00; // Precio del café
    }
    
}
