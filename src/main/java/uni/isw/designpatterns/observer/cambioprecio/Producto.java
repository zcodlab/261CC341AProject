package uni.isw.designpatterns.observer.cambioprecio;

import java.util.ArrayList;
import java.util.List;

public class Producto implements SujetoObservable{
    private String nombre;
    private double precio;
    private List<Observador> observadores;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.observadores = new ArrayList<>();
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }
    
    @Override
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
        notificar();
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
    

    @Override
    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizar(this);
        }
    }
}
