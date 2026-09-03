public class DescuentoConvenio implements EstrategiaDescuento{
    final double descuento = 30.00;

    @Override
    public Double aplicarDescuento(Double costoBase) {
        return ((costoBase-(this.descuento*costoBase)/100));
    }
}
