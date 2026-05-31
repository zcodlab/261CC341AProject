package uni.isw.designpatterns.dinjection.after;

public class UsuarioServicio {
    UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }  
    
    public String getUsuario(){
        return usuarioRepositorio.getUsuario();
    }
}
