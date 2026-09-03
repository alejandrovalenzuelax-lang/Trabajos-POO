import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IntentoInvalidoException, CuentaBloqueadaException {

        int intentos = 0;
        Scanner teclado = new Scanner(System.in);
        String nipRecibido;
        CajeroAutomatico cajero1 = new CajeroAutomatico();

        while (intentos<3){
            System.out.println("Ingresa tu nip: ");
            nipRecibido = teclado.nextLine();
            try {
                if (cajero1.validarNip(nipRecibido)) {
                    System.out.println("Ingreso con exito...");
                    break;
                }
            } catch (IntentoInvalidoException e) {
                intentos++;
                System.out.println(e.getMessage());
            }
        }
        if (intentos == 3) {
            throw new CuentaBloqueadaException("Cuenta bloqueada");
        }


    }
}