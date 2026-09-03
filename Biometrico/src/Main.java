//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FabricaHardware.configurar();

        SensorBiometrico sensor1 = new SensorBiometrico(1001);
        SensorBiometrico sensor2 = new SensorBiometrico(null);
        SensorBiometrico sensor3 = new SensorBiometrico(1002);
        SensorBiometrico sensor4 = new SensorBiometrico(null);

        RegistroAsistencia.verificar(sensor1);
        RegistroAsistencia.verificar(sensor2);
        RegistroAsistencia.verificar(sensor3);
        RegistroAsistencia.verificar(sensor4);
    }
}