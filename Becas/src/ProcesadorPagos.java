public class ProcesadorPagos {

    public static boolean pago(Beca beca){
        return beca.esValida() ? true : false;
    }
}
