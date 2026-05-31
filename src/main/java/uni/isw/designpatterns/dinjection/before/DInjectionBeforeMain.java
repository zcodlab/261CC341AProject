package uni.isw.designpatterns.dinjection.before;

public class DInjectionBeforeMain {
    public static void main(String[] args){
        UsuarioServicio usuarioServicio=new UsuarioServicio();
        System.out.println(usuarioServicio.getUsuario());
    }
    
}
