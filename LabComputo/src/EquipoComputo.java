public abstract class EquipoComputo {
    static int totalEquiposEnSala;
    public final Double coordenadaX;
    public final Double coordenadaY;

    public EquipoComputo(Double x, Double y) {
        coordenadaX = x;
        coordenadaY = y;
        totalEquiposEnSala++;
    }
}
