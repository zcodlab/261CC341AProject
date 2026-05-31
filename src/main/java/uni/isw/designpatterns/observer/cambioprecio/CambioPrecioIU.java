package uni.isw.designpatterns.observer.cambioprecio;

public class CambioPrecioIU {
    public static void main(String[] args) {
        Producto producto = new Producto("Laptop", 1000.00);

        Cliente cliente1 = new Cliente("Juan");
        Cliente cliente2 = new Cliente("Maria");

        producto.agregarObservador(cliente1);
        producto.agregarObservador(cliente2);

        // Cambiar el precio del producto
        producto.setPrecio(900.00);  // Notificará a los clientes

        // Cambiar el precio nuevamente
        producto.setPrecio(850.00);  // Notificará a los clientes
    }
}
