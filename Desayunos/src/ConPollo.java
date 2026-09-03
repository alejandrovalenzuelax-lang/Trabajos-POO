public class ConPollo extends ComplementoAlmuerzo{

    final private String detalle = "Con Pollo";
    final private int costoExtra = 10;

    public ConPollo(Alimento ordenActual) {
        super(ordenActual);
    }

    @Override
    public Double getPrecio() {
        return costoExtra+ordenActual.getPrecio();
    }

    @Override
    public String getDetalle() {
        return detalle+" + "+ ordenActual.getDetalle();
    }

}
