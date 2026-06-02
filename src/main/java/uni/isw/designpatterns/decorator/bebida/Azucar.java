package uni.isw.designpatterns.decorator.bebida;

// Decorador concreto: Azúcar
public class Azucar extends BebidaDecorador {
    public Azucar(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescripcion() {
        return bebida.getDescripcion() + ", Azúcar";
    }

    @Override
    public double costo() {
        return bebida.costo() + 0.20; // Precio adicional por azúcar
    }
    
}
