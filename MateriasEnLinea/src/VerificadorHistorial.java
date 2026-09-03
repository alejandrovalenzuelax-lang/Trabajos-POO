import java.util.List;

public class VerificadorHistorial {

    public boolean verificar (Alumno alumno){
        for (Integer calificacion : alumno.getCalificaciones()){
            if (calificacion < 6){
                System.out.println("Error: Materias Reprobadas...");
                return false;
            }
        }
        return true;
    }

}
