public class ValidacionPago extends FiltroAdmision{
    boolean fichaDePago;

    public ValidacionPago(boolean fichaDePago) {
        this.fichaDePago = fichaDePago;
    }


    @Override
    boolean validar(String nombre) {
        if (this.fichaDePago){
            System.out.println(nombre+"Ficha de pago... ok.");
            if (siguienteFiltro != null){
                return siguienteFiltro.validar(nombre);
            }else{
                System.out.println(nombre+"Registro completo...");
                return true;
            }
        }else{
            System.out.println(nombre+"Error Ficha de pago incompleta...");
            return false;
        }
    }
}
