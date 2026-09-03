public class Main {
    public static void main(String[] args) {
        // Crear tarjetas
        TarjetaEscolarEstudiante estudiante = new TarjetaEscolarEstudiante(100);
        TarjetaProveedor proveedor = new TarjetaProveedor(500);

        // Caso 1: Estudiante consulta saldo
        System.out.println("=== Caso 1: Estudiante consulta saldo ===");
        System.out.println("Saldo estudiante: " + estudiante.consultarSaldo());

        // Caso 2: Estudiante compra
        System.out.println("\n=== Caso 2: Estudiante compra ===");
        double nuevoSaldoEstudiante = PuntoDeVenta.procesarCompra(estudiante, 30.0);
        System.out.println("Saldo después de compra: " + nuevoSaldoEstudiante);

        // Caso 3: Proveedor consulta saldo
        System.out.println("\n=== Caso 3: Proveedor consulta saldo ===");
        System.out.println("Saldo proveedor: " + proveedor.consultarSaldo());

        // Caso 4: Proveedor retira dinero
        System.out.println("\n=== Caso 4: Proveedor retira dinero ===");
        double nuevoSaldoRetiro = PuntoDeVenta.procesarRetiro(proveedor, 100.0);
        System.out.println("Saldo después de retiro: " + nuevoSaldoRetiro);

        // Caso 5: Proveedor deposita dinero
        System.out.println("\n=== Caso 5: Proveedor deposita dinero ===");
        double nuevoSaldoDeposito = PuntoDeVenta.procesarDeposito(proveedor, 200.0);
        System.out.println("Saldo después de depósito: " + nuevoSaldoDeposito);
    }
}