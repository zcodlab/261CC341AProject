package uni.isw.designpatterns.observer.cambioprecio;

public interface SujetoObservable {
    public void agregarObservador(Observador observador);
    public void eliminarObservador(Observador observador);
    public void notificar();
}
