package uni.isw.grasp.Nohablesconextranios;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private List<Curso> cursos;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.cursos=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
    
    public void agregarCurso(Curso curso){
        if(!cursos.contains(curso))
            cursos.add(curso);
    }
    
}
