public class Factura {
    final String monedaOrigen = "MXN";
    final String monedaDestino = "USD";
    Double precio;

    public Factura(Double precio) {
        this.precio = precio;
    }

    public Double obtenerPrecioConvertido(){
        return BancoCentralEscolar.conversionUsd(this.precio);
    }
}
