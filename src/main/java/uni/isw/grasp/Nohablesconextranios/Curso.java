package uni.isw.grasp.Nohablesconextranios;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public void inscribirEstudiante(Estudiante estudiante){
        if(!estudiantes.contains(estudiante)){
            estudiantes.add(estudiante);
            //Habla con un amigo, el parametro
            estudiante.agregarCurso(this);
        }
    }
            
    
}
