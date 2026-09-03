import java.util.HashMap;
import java.util.Map;

public class SistemasVotaciones {


    Map<String, Integer> votosPorCandidato;

    public SistemasVotaciones() {
        this.votosPorCandidato = new HashMap<>();
    }

    public void registrarVoto(String candidato){
        int votos = votosPorCandidato.getOrDefault(candidato,0);
        votosPorCandidato.put(candidato,votos+1 );
    }

    public void mostrarResultados(){
        for (Map.Entry<String,Integer> entrada : votosPorCandidato.entrySet()){
            String candidato = entrada.getKey();
            Integer votos = entrada.getValue();

            System.out.println(candidato + ": "+ votos + "votos");
        }
    }

    public void mostrarCandidatos(){
        for (String candidato : votosPorCandidato.keySet()){
            System.out.println(candidato);
        }
    }

    public Integer ObtenerVotos(String candidato){
        if (votosPorCandidato.containsKey(candidato)){
            return votosPorCandidato.get(candidato);
        }
        return null;
    }



}
