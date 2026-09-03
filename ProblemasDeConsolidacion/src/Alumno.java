public class Alumno {

    private final String matricula;
    private final String nombre;
    private final String materia;


    public Alumno(String matricula, String nombre, String materia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.materia = materia;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMateria() {
        return materia;
    }
}
