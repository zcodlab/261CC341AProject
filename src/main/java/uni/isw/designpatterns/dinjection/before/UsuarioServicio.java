package uni.isw.designpatterns.dinjection.before;

public class UsuarioServicio {
    UsuarioRepositorio usuarioRepositorio
            =new UsuarioRepositorio();
    
    public String getUsuario(){
        return usuarioRepositorio.getUsuario();
    }
}
