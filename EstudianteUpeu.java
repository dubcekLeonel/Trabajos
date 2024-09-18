
public class EstudianteUpeu extends Persona {
    protected String nombre;
    protected String apellido;
    protected int id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNotas() {
        return notas;
    }

    public void setNotas(int notas) {
        this.notas = notas;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String facultad;
    protected String carrera;
    protected int ciclo;
    protected int grupo;
    protected int codigo;
    protected int notas;
    protected String cursos;

    public EstudianteUpeu() {
    }

    public EstudianteUpeu(String facultad, String carrera, int ciclo, int grupo, int codigo, int notas, String cursos,
            String nombre, String apellido, short edad, long dni, String nacionalidad) {

        super(nombre, apellido, edad, dni, nacionalidad);
        this.facultad = facultad;
        this.carrera = carrera;
        this.ciclo = ciclo;
        this.grupo = grupo;
        this.codigo = codigo;
        this.notas = notas;
        this.cursos = cursos;

    }

    public EstudianteUpeu(int id, String nombre, String apellido, int codigo) {

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        // Persona persona = new Persona();
       // return "ID:   " + id + persona.toString() + "Codigo: " + codigo;
        // return "Id: " + id + super.toString() + "Codigo: " + codigo;
        return "ID: " + id + "  Nombre: " + nombre + " Apellido: " + apellido + " Codigo: " + codigo;
    }

}