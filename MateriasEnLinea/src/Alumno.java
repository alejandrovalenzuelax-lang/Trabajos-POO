import java.util.List;

public class Alumno {
    final String escuela = "Global University";
    private List<Integer> calificaciones;
    String nombre;
    String grado;

    public Alumno(List<Integer> calificaciones, String nombre, String grado) {
        this.calificaciones = calificaciones;
        this.nombre = nombre;
        this.grado = grado;
    }

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }
}
