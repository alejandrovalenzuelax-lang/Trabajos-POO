import java.util.HashSet;
import java.util.Set;

public class ControlSeguridad {

    private static Set<String> listaNegra = new HashSet<>();


    public static void agregarMatriculaRobada(String matricula){
        listaNegra.add(matricula);
    }

    public static boolean verificarAlerta(String matricula){
        return listaNegra.contains(matricula);
    }


}
