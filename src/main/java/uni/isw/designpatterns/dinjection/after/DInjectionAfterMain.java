package uni.isw.designpatterns.dinjection.after;

public class DInjectionAfterMain {
    public static void main(String[] args){
        UsuarioRepositorio usuarioRepositorio =new UsuarioPostgresqlRepositorio();
        
        UsuarioServicio usuarioServicio=new UsuarioServicio(usuarioRepositorio);
        System.out.println(usuarioServicio.getUsuario());
    }
    
}
