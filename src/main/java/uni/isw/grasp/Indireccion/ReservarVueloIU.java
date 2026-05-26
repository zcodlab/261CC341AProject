package uni.isw.grasp.Indireccion;

public class ReservarVueloIU {
    
    private ReservarVueloController reservarManager;
    
    public static void main(String[] args){
        ReservarVueloIU reservaIU=new ReservarVueloIU();
        reservaIU.realizarReserva();
    }
    private void realizarReserva(){
        reservarManager=new ReservarVueloController();
        Vuelo vuelo=new Vuelo("Lima","Arequipa");
        reservarManager.realizarReserva(vuelo);               
    }
    
}
