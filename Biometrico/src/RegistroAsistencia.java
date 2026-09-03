public class RegistroAsistencia {

    public static void verificar(SensorBiometrico sensor){
        if (sensor.codigoEmpleado == null){
            System.out.println("No se registro asistencia");
            FabricaHardware.reiniciar();
        }else{
            System.out.println("Asistencia Registrada");
        }
    }
}
