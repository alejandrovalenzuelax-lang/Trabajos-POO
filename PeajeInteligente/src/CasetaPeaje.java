import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasetaPeaje {

    private final String idCaseta;
    private List<Vehiculo> historialCruces;
    private Map<String,Double> recaudacionPorTipo;

    public CasetaPeaje(String idCaseta) {
        this.idCaseta = idCaseta;
        this.historialCruces = new ArrayList<>();
        this.recaudacionPorTipo = new HashMap<>();
    }

    public void registrarPaso(Vehiculo vehiculo, CalculoPeaje calulador){
        if(ControlSeguridad.verificarAlerta(vehiculo.getMatricula())){
            System.out.println("Alerta de seguridad! Vehiculo Robado");
            return;
        }

        Double tarifa = calulador.calcularTarifa(vehiculo);

        historialCruces.add(vehiculo);

        String tipo = "";

        if(vehiculo instanceof AutoParticular){
            tipo = "Auto";
        } else if (vehiculo instanceof CamionCarga) {
            tipo = "Camion";
        }

        Double acumuladoActual = recaudacionPorTipo.getOrDefault(tipo, 0.0);
        recaudacionPorTipo.put(tipo, acumuladoActual + tarifa);


    }

    public void imprimirHistorial() {
        System.out.println("Historial de cruces de la caseta " + idCaseta + ":");

        for (Vehiculo vehiculo : historialCruces) {
            System.out.println(
                    "Matricula: " + vehiculo.getMatricula()
                            + " | Modelo: " + vehiculo.getModelo()
                            + " | Peso: " + vehiculo.getPesoToneladas()
            );
        }
    }

    public void imprimirReporteRecaudacion() {
        System.out.println("Reporte de recaudacion de la caseta " + idCaseta + ":");

        for (Map.Entry<String, Double> entrada : recaudacionPorTipo.entrySet()) {
            System.out.println(
                    entrada.getKey() + ": $" + entrada.getValue()
            );
        }
    }



}
