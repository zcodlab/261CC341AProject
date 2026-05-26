package uni.isw.grasp.Indireccion;

public class Vuelo {
    private String origen;
    private String destino;

    public Vuelo(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }
    
    //Metodo para reservar el vuelo
    public void reservar(){
        System.out.println("Vuelo reservado: "+ toString());
    }

    @Override
    public String toString() {
        return "Vuelo{" + "origen=" + origen + ", destino=" + destino + '}';
    }
    
    
}
