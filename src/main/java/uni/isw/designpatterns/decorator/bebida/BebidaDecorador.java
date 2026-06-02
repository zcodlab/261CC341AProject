package uni.isw.designpatterns.decorator.bebida;

// Clase decoradora abstracta
public abstract class BebidaDecorador implements Bebida{
    protected Bebida bebida;

    public BebidaDecorador(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getDescripcion() {
        return bebida.getDescripcion();
    }

    @Override
    public double costo() {
        return bebida.costo();
    }
}
