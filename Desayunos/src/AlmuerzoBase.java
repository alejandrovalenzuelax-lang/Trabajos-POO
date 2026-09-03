public class AlmuerzoBase implements Alimento {
    final String detalle = "Chilaquiles sencillos";
    final Double precio = 50.00;


    @Override
    public Double getPrecio() {
        return precio;
    }

    @Override
    public String getDetalle() {
        return detalle;
    }
}
