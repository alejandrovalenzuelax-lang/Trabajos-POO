//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PaqueteDiploma diploma1 = new PaqueteDiploma(20.00,50.00);
        DireccionDestino destino1 = new DireccionDestino(20266);
        DHL paqueteria1 = new DHL();

        CoordinadorEnvios envio1 = new CoordinadorEnvios(destino1,paqueteria1,diploma1);
        System.out.println(envio1.informacionEnvio());

        PaqueteDiploma diploma2 = new PaqueteDiploma(40.00,30.00);
        DireccionDestino destino2 = new DireccionDestino(20000);
        FEDEX paqueteria2 = new FEDEX();

        CoordinadorEnvios envio2 = new CoordinadorEnvios(destino2,paqueteria2,diploma2);
        System.out.println(envio2.informacionEnvio());



    }
}