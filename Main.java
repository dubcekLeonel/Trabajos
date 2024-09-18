import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestionEstudianUpeu GestionEstudianUpeu = new GestionEstudianUpeu();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.println("------------------------------------------------");
                System.out.println("Registro de datos de los estudiantes de la UpeU");
                System.out.println("------------------------------------------------");
                System.out.println("1. Agregar estudiante");
                System.out.println("2. Actualizar estudiante");
                System.out.println("3. Eliminar estudiante");
                System.out.println("4. Ver la lista de estudiantes ");
                System.out.println("5. salir");

                int opciones = input.nextInt();

                switch (opciones) {
                    case 1:
                        input.nextLine();
                        System.out.println("Nombre: ");
                        String nombre = input.nextLine();
                        System.out.println("Apellido: ");
                        String apellido = input.nextLine();
                        System.out.println("Codigo de estudiante: ");
                        int codigo = input.nextInt();

                        GestionEstudianUpeu.agregarEstudiante(nombre, apellido, codigo);

                        break;
                    case 2:
                        System.out.println("Estudiante a actulizar");
                        System.out.println("id: ");
                        int id = input.nextInt();
                        input.nextLine();
                        System.out.println("Nuevo nombre: ");
                        nombre = input.nextLine();
                        System.out.println("Nuevo Apellido: ");
                        apellido = input.nextLine();
                        System.out.println("Nuevo codigo: ");
                        codigo = input.nextInt();
                        GestionEstudianUpeu.actualizarEstudiante(id, nombre, apellido, codigo);
                        break;
                    case 3:
                        System.out.println("Eliminar Estudiante ");
                        System.out.println("id: ");
                        id = input.nextInt();
                        GestionEstudianUpeu.eliminarEstudiante(id);
                        break;
                    case 4:
                        System.out.println("Esta es la lista de estudiantes: \n");
                        GestionEstudianUpeu.listarEstudiantes();
                        break;
                    case 5:
                        System.out.println("cerrando sesion...");
                        input.close();
                        return;

                    default:
                        System.out.println("Error, intente de nuevo\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, r u David??");
                input.nextLine();
            }
            catch(Exception e){
                System.out.println("algo ocurrio");
            }

        }

    }

}
