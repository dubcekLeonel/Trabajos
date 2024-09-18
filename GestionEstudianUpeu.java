import java.util.ArrayList;
import java.util.List;

public class GestionEstudianUpeu extends EstudianteUpeu {

    // List<EstudianteUpeu> estudiantes;
    // estudiantes = new ArrayList<>();
    // private List<EstudianteUpeu> UpeuEstudent= new ArrayList<>();

    List<EstudianteUpeu> UpeuStudent;
    private int nextId;

    // public GestionEstudianUpeu(){}
    public GestionEstudianUpeu() {
        UpeuStudent = new ArrayList<>();
        nextId = 1;
    }

    public void agregarEstudiante(String nombre, String apellido, int codigo) {

        EstudianteUpeu nuevoEstudiante = new EstudianteUpeu(nextId++, nombre, apellido, codigo);
        UpeuStudent.add(nuevoEstudiante);

    }

    public void actualizarEstudiante(int id, String nombre, String apellido, int codigo) {

        for (EstudianteUpeu estudianteUpeu : UpeuStudent) {
            if (estudianteUpeu.getId() == id) {
                estudianteUpeu.setNombre(nombre);
                estudianteUpeu.setApellido(apellido);
                estudianteUpeu.setCodigo(codigo);
                return;
            } else {
                System.out.println("El estudiante no fue encontrado, intente de nuevo por favor.");
            }
        }

    }

    public void eliminarEstudiante(int id) {
        UpeuStudent.removeIf(upeustudent -> upeustudent.getId() == id);
    }

    public void listarEstudiantes() {
        for (EstudianteUpeu estudianteUpeu : UpeuStudent) {
            System.out.println(estudianteUpeu);
        }

    }
    
}
