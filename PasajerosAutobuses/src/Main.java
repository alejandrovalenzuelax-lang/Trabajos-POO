public class Main {
    public static void main(String[] args) {

        SistemaAutobuses sistema = new SistemaAutobuses();

        sistema.registrarPasajero("Ana Lopez");
        sistema.registrarPasajero("Luis Perez");
        sistema.registrarPasajero("Maria Garcia");
        sistema.registrarPasajero("Ana Lopez");
        sistema.registrarPasajero("Carlos Ruiz");
        sistema.registrarPasajero("Luis Perez");

        System.out.println("=== Asientos del viaje actual ===");
        sistema.mostrarAsientos();

        System.out.println();

        System.out.println("=== Pasajeros unicos del mes ===");
        sistema.mostrarPasajerosUnicosMes();

        System.out.println();

        System.out.println("=== Busqueda en historial mensual ===");

        String pasajero1 = "Ana Lopez";
        if (sistema.buscarPasajeroFrecuente(pasajero1)) {
            System.out.println(pasajero1 + " ya aparece en el historial del mes.");
        } else {
            System.out.println(pasajero1 + " no aparece en el historial del mes.");
        }

        String pasajero2 = "Sofia Torres";
        if (sistema.buscarPasajeroFrecuente(pasajero2)) {
            System.out.println(pasajero2 + " ya aparece en el historial del mes.");
        } else {
            System.out.println(pasajero2 + " no aparece en el historial del mes.");
        }
    }
}