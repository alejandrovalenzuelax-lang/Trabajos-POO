import java.util.HashMap;
import java.util.Map;

public class AnalizadorEnsayos {

    private final Map<String,Integer> frecuenciaPalabras;

    public AnalizadorEnsayos() {
        this.frecuenciaPalabras = new HashMap<>();
    }


    public void analizarTexto(String texto) {
        texto = texto.toLowerCase();

        texto = texto.replaceAll("[^a-záéíóúñü\\s]", "");

        String[] palabras = texto.split("\\s+");

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                int frecuenciaActual = frecuenciaPalabras.getOrDefault(palabra, 0);
                frecuenciaPalabras.put(palabra, frecuenciaActual + 1);
            }
        }
    }

    public void mostrarFrecuencias(){
        for (Map.Entry<String,Integer> Entrada : frecuenciaPalabras.entrySet()){
            String palabra = Entrada.getKey();
            Integer frecuencia = Entrada.getValue();
            System.out.println("Palabra: "+" '"+ palabra+"' "+ " Se repite: "+ frecuencia+" veces ");
        }
    }

    public void obtenerFrecuencia (String palabra){
        Integer frecuencia = frecuenciaPalabras.get(palabra);
        System.out.println("Frecuencia de la palabra: "+" '"+ palabra+"' " + " Frecuencia: "+frecuencia);
    }

    public void mostrarPalabrasUnicas() {
        if (frecuenciaPalabras.isEmpty()) {
            System.out.println("No hay palabras registradas.");
            return;
        }

        for (String palabra : frecuenciaPalabras.keySet()) {
            System.out.println(palabra);
        }
    }


}
