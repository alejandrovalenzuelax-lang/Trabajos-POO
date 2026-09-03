public class TarjetaEscolarEstudiante implements Consultable{
    public double saldo;

    public TarjetaEscolarEstudiante(int saldo) {
        this.saldo = saldo;
    }

    public double comprar(Double monto){
        return this.saldo=this.saldo-monto;
    }

    @Override
    public double consultarSaldo() {
        return this.saldo;
    }
}
