//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno();
        DescuentoEmpleado descuento1= new DescuentoEmpleado();
        System.out.println(CalculadoraColegiatura.calcular(alumno1,descuento1));
        Alumno alumno2 = new Alumno();
        DescuentoConvenio descuento2 = new DescuentoConvenio();
        System.out.println(CalculadoraColegiatura.calcular(alumno2,descuento2));
        Alumno alumno3 = new Alumno();
        SinDescuento descuento3 = new SinDescuento();
        System.out.println(CalculadoraColegiatura.calcular(alumno3,descuento3));
    }
}