public class DescuentoEmpleado implements EstrategiaDescuento{
    final double descuento = 50.00;

    @Override
    public Double aplicarDescuento(Double costoBase) {
        return ((costoBase-(this.descuento*costoBase)/100));
    }
}
