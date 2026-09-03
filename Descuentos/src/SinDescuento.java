public class SinDescuento implements EstrategiaDescuento {
    final double descuento=0.0;

    @Override
    public Double aplicarDescuento(Double costoBase) {
        return ((costoBase-(this.descuento*costoBase)/100));
    }
}
