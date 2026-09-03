//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BecaDeportiva beca1 = new BecaDeportiva(100L);
        BecaExcelencia beca2 = new BecaExcelencia(50L);
        BecaDeportiva beca3 = new BecaDeportiva(0L);
        BecaExcelencia beca4 = new BecaExcelencia(-5L);

        System.out.println(ProcesadorPagos.pago(beca1) ? "Pago realizado" : "Pago rechazado");
        System.out.println(ProcesadorPagos.pago(beca2) ? "Pago realizado" : "Pago rechazado");
        System.out.println(ProcesadorPagos.pago(beca3) ? "Pago realizado" : "Pago rechazado");
        System.out.println(ProcesadorPagos.pago(beca4) ? "Pago realizado" : "Pago rechazado");


    }
}