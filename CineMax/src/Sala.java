public class Sala {
    private final int asientos = 30;
    private int asientosOcupados;

    public void reservarAsientos(int solicitudAsientos) throws ReservaInvalidaException {
        if (solicitudAsientos < 0) {
            throw new ReservaInvalidaException("No se puede reservar un número negativo de asientos.");
        }

        if (solicitudAsientos > obtenerAsientosDisponibles()) {
            throw new ReservaInvalidaException("No hay suficientes asientos disponibles.");
        }

        asientosOcupados = asientosOcupados + solicitudAsientos;
    }

    public int obtenerAsientosDisponibles() {
        return asientos - asientosOcupados;
    }

    public int getAsientosOcupados() {
        return asientosOcupados;
    }
}