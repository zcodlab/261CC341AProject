package uni.isw.designpatterns.decorator.bebida;

public class BebidaMain {
    public static void main(String[] args) {
        // Crear una bebida
        Bebida miBebida = new Cafe();
        System.out.println(miBebida.getDescripcion() + " $ " + miBebida.costo());

        // Decorar la bebida con leche
        miBebida = new Leche(miBebida);
        System.out.println(miBebida.getDescripcion() + " $ " + miBebida.costo());

        // Decorar la bebida con azúcar
        miBebida = new Azucar(miBebida);
        System.out.println(miBebida.getDescripcion() + " $ " + miBebida.costo());
    }
}
