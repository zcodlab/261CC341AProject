package uni.isw.designpatterns.observer.cambioprecio;

public class Cliente implements Observador {

    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Producto producto) {
        System.out.println("Hola " + nombre + ", el nuevo precio de " + producto.getNombre() + " es: $" + producto.getPrecio());
    }
    
}
