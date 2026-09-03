public class Main {
    public static void main(String[] args) {

        HistorialNavegacion historial = new HistorialNavegacion();

        System.out.println("=== Pagina actual al inicio ===");
        String actual = historial.paginaActual();

        if (actual == null) {
            System.out.println("No hay pagina actual.");
        } else {
            System.out.println("Pagina actual: " + actual);
        }

        System.out.println();

        System.out.println("=== Intentar ir atras sin paginas ===");
        historial.irAtras();

        System.out.println();

        System.out.println("=== Visitando paginas ===");
        historial.visitarPagina("google.com");
        historial.visitarPagina("wikipedia.org");
        historial.visitarPagina("openai.com");
        historial.visitarPagina("github.com");

        System.out.println("Historial completo:");
        historial.mostrarHistorial();

        System.out.println();

        System.out.println("=== Pagina actual ===");
        actual = historial.paginaActual();

        if (actual == null) {
            System.out.println("No hay pagina actual.");
        } else {
            System.out.println("Pagina actual: " + actual);
        }

        System.out.println();

        System.out.println("=== Ir atras una vez ===");
        historial.irAtras();

        actual = historial.paginaActual();
        if (actual == null) {
            System.out.println("No hay pagina actual.");
        } else {
            System.out.println("Pagina actual: " + actual);
        }

        System.out.println();

        System.out.println("Historial despues de ir atras:");
        historial.mostrarHistorial();

        System.out.println();

        System.out.println("=== Ir atras varias veces ===");
        historial.irAtras();
        historial.irAtras();
        historial.irAtras();
        historial.irAtras();

        actual = historial.paginaActual();
        if (actual == null) {
            System.out.println("No hay pagina actual.");
        } else {
            System.out.println("Pagina actual: " + actual);
        }

        System.out.println();

        System.out.println("Historial final:");
        historial.mostrarHistorial();
    }
}