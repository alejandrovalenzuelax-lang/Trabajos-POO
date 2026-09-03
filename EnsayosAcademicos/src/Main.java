public class Main {
    public static void main(String[] args) {

        AnalizadorEnsayos analizador = new AnalizadorEnsayos();

        String ensayo = "La literatura es arte. La literatura expresa ideas, emociones y cultura. "
                + "El ensayo académico analiza ideas; el ensayo también organiza argumentos. "
                + "Literatura, literatura y más literatura.";

        System.out.println("=== Analizando ensayo ===");
        analizador.analizarTexto(ensayo);

        System.out.println();

        System.out.println("=== Frecuencia de palabras ===");
        analizador.mostrarFrecuencias();

        System.out.println();

        System.out.println("=== Palabras unicas ===");
        analizador.mostrarPalabrasUnicas();

        System.out.println();

        System.out.println("=== Consultas especificas ===");
        analizador.obtenerFrecuencia("literatura");
        analizador.obtenerFrecuencia("ensayo");
        analizador.obtenerFrecuencia("poesia");
    }
}
