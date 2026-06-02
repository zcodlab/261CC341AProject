package uni.isw.designpatterns.decorator.bebida;

// Decorador concreto: Leche
public class Leche extends BebidaDecorador {
    public Leche(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescripcion() {
        return bebida.getDescripcion() + ", Leche";
    }

    @Override
    public double costo() {
        return bebida.costo() + 0.50; // Precio adicional por leche
    }
    
}
