import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SistemaAutobuses {

    private final List<String> pasajerosViajeActual;
    private final Set<String> pasajerosUnicosMes;

    public SistemaAutobuses() {
        this.pasajerosViajeActual = new ArrayList<>();
        this.pasajerosUnicosMes = new HashSet<>();
    }

    public void registrarPasajero (String nombre){
        pasajerosViajeActual.add(nombre);
        pasajerosUnicosMes.add(nombre);
    }

    public void mostrarAsientos(){
        for (int i = 0; i < pasajerosViajeActual.size();i++){
            System.out.println("Asiento "+ (i+1) + ": " + pasajerosViajeActual.get(i));
        }
    }

    public void mostrarPasajerosUnicosMes(){
        System.out.println("---Pasajeros del mes----");
        for(String pasajero : pasajerosUnicosMes){
            System.out.println(pasajero);
        }
    }

    public boolean buscarPasajeroFrecuente(String nombre) {
        return pasajerosUnicosMes.contains(nombre);
    }

}
