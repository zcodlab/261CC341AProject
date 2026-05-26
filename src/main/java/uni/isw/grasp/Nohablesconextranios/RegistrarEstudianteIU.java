package uni.isw.grasp.Nohablesconextranios;

public class RegistrarEstudianteIU {
    private Estudiante estudiante;
    private Curso curso;
    
    public static void main(String[] args){
        RegistrarEstudianteIU registroIU=new RegistrarEstudianteIU();        
        registroIU.registrarEstudiante();
        registroIU.visualizarResgistro();
        
    }
    private void registrarEstudiante(){
        curso=new Curso("Ingenieria de Software");
        estudiante=new Estudiante("Juan");
        //Inscribiremos al estudiante en el curso
        curso.inscribirEstudiante(estudiante);
    }
    private void visualizarResgistro(){
        System.out.println("Curso: "+ curso.getNombre());        
        for(Estudiante e: curso.getEstudiantes())
            System.out.println("Estudiante inscrito: "+ estudiante.getNombre());
        //Si aplicas de Patron -> no esta permitido lo siguiente:
        System.out.println("Llamada incorrecta: "+ estudiante.getCursos().get(0).getNombre());        
    }
    
}
