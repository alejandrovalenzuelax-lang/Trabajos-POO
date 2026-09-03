import java.util.*;

public class ControlEscolar {


    private final List<Alumno> filaDeLlegada;
    private final Set<String> matriculasProcesadas;
    private final Map<String,Alumno> alumnosPorMatricula;

    public ControlEscolar() {
        this.filaDeLlegada = new ArrayList<>();
        this.matriculasProcesadas = new HashSet<>();
        this.alumnosPorMatricula = new HashMap<>();
    }

    public void registrarLlegada(Alumno al) throws ExistenteException{
        filaDeLlegada.add(al);
        if (matriculasProcesadas.contains(al.getMatricula())){
            throw new ExistenteException("Ya existente... Siguiente");
        }else{
            alumnosPorMatricula.put(al.getMatricula(), al);
            matriculasProcesadas.add(al.getMatricula());
        }
    }


}
