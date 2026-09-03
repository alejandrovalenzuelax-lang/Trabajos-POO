//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Factura factura1 = new Factura(250.0);
        Factura factura2 = new Factura(349.90);

        System.out.println(factura1.obtenerPrecioConvertido());
        System.out.println(factura2.obtenerPrecioConvertido());

    }
}