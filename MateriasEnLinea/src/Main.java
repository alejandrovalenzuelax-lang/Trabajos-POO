import java.util.List;

public class Main {
    public static void main(String[] args) {
        VerificadorHistorial verificador = new VerificadorHistorial();
        GeneradorComprobante generador = new GeneradorComprobante();

        ProcesoInscripcion proceso =
                new ProcesoInscripcion(generador, verificador);

        Alumno alumnoAprobado = new Alumno(
                List.of(10, 8, 7, 9),
                "Ana",
                "Segundo semestre"
        );

        Alumno alumnoReprobado = new Alumno(
                List.of(10, 5, 8, 9),
                "Carlos",
                "Tercer semestre"
        );

        Alumno alumnoConSeis = new Alumno(
                List.of(6, 6, 7, 8),
                "María",
                "Primer semestre"
        );

        Alumno alumnoSinCalificaciones = new Alumno(
                List.of(),
                "Luis",
                "Primer semestre"
        );

        System.out.println(
                alumnoAprobado.nombre + ": "
                        + proceso.procesarInscripcion(alumnoAprobado)
        );

        System.out.println(
                alumnoReprobado.nombre + ": "
                        + proceso.procesarInscripcion(alumnoReprobado)
        );

        System.out.println(
                alumnoConSeis.nombre + ": "
                        + proceso.procesarInscripcion(alumnoConSeis)
        );

        System.out.println(
                alumnoSinCalificaciones.nombre + ": "
                        + proceso.procesarInscripcion(alumnoSinCalificaciones)
        );
    }
}