public class TarjetaProveedor implements Consultable,Retirable{
    public double saldo;

    public TarjetaProveedor(int saldo) {
        this.saldo = saldo;
    }


    @Override
    public double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public double retirarDinero(Double cantidad) {
        return this.saldo=this.saldo-cantidad ;
    }

    @Override
    public double depositarDinero( Double cantidad) {
        return this.saldo=this.saldo+cantidad;
    }
}
