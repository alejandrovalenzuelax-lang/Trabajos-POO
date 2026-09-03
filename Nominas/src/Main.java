public class Main {
    public static void main(String[] args) {
        ProcesadorNomina procesador = new ProcesadorNomina();

        Double total = procesador.procesarArchivo("nomina.txt");

        System.out.println("Total de nomina: " + total);
    }
}