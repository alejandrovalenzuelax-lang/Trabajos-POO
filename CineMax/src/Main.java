public class Main {
    public static void main(String[] args) {
        Sala sala = new Sala();

        try {
            sala.reservarAsientos(10);
            System.out.println("Reserva realizada correctamente.");
            System.out.println("Asientos disponibles: " + sala.obtenerAsientosDisponibles());

            sala.reservarAsientos(25);
            System.out.println("Reserva realizada correctamente.");
        } catch (ReservaInvalidaException e) {
            System.out.println("Error al reservar: " + e.getMessage());
        }
    }
}