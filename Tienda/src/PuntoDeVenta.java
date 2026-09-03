public class PuntoDeVenta {


    static public double procesarCompra(TarjetaEscolarEstudiante tarjeta, Double cantidad){
        return tarjeta.comprar(cantidad);
    }

    static public double procesarRetiro(TarjetaProveedor tarjeta,Double cantidad){
        return tarjeta.retirarDinero(cantidad);
    }

    static public double procesarDeposito(TarjetaProveedor tarjeta, Double cantidad){
        return tarjeta.depositarDinero(cantidad);
    }
}
