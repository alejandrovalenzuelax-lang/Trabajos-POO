//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ComputadoraEscritorio device = new ComputadoraEscritorio(0.0,0.0);
        LaptopEstudiante device1 = new LaptopEstudiante(10.0,10.0);
        LaptopEstudiante device2 = new LaptopEstudiante(100.0,100.0);

        VerificadorConexion verificador = new VerificadorConexion();
        boolean resultado = verificador.calcularDistancia(device);
        boolean resultado1 = verificador.calcularDistancia(device1);
        boolean resultado2 = verificador.calcularDistancia(device2);

        if(resultado){
            System.out.println("La conexion ha sido exitosa...");
        }else{
            System.out.println("Error: Conexion fallida...");
        }
        if(resultado1){
            System.out.println("La conexion ha sido exitosa...");
        }else{
            System.out.println("Error: Conexion fallida...");
        }
        if(resultado2){
            System.out.println("La conexion ha sido exitosa...");
        }else{
            System.out.println("Error: Conexion fallida...");
        }

    }
}