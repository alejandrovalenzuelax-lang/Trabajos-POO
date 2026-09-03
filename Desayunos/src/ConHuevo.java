public class ConHuevo extends ComplementoAlmuerzo{

    final private String complemento = "Con Huevo";
    final private int costoExtra = 20;

    public ConHuevo(Alimento ordenActual) {
        super(ordenActual);
    }


    @Override
    public Double getPrecio() {
        return costoExtra+ordenActual.getPrecio();
    }

    @Override
    public String getDetalle() {
        return ordenActual.getDetalle()+" + "+complemento;
    }
}
