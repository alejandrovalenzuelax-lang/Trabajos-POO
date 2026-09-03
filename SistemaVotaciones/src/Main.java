public class Main {
    public static void main(String[] args) {

        SistemasVotaciones sistema = new SistemasVotaciones();

        System.out.println("=== Resultados antes de votar ===");
        sistema.mostrarResultados();

        System.out.println();

        System.out.println("=== Registrando votos ===");
        sistema.registrarVoto("Ana");
        sistema.registrarVoto("Luis");
        sistema.registrarVoto("Ana");
        sistema.registrarVoto("Maria");
        sistema.registrarVoto("Ana");
        sistema.registrarVoto("Luis");
        sistema.registrarVoto("Carlos");

        System.out.println();

        System.out.println("=== Resultados finales ===");
        sistema.mostrarResultados();

        System.out.println();

        System.out.println("=== Candidatos registrados ===");
        sistema.mostrarCandidatos();

        System.out.println();

        System.out.println("=== Consultar votos de candidato existente ===");
        Integer votosAna = sistema.ObtenerVotos("Ana");

        if (votosAna != null) {
            System.out.println("Ana tiene " + votosAna + " votos.");
        } else {
            System.out.println("Ana no esta registrada.");
        }

        System.out.println();

        System.out.println("=== Consultar votos de candidato inexistente ===");
        Integer votosSofia = sistema.ObtenerVotos("Sofia");

        if (votosSofia != null) {
            System.out.println("Sofia tiene " + votosSofia + " votos.");
        } else {
            System.out.println("Sofia no esta registrada.");
        }
    }
}