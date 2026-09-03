public class SmsDirector implements CanalComunicacion{


    @Override
    public String enviarAlerta(String texto) {
        return "Este mensaje es acerca de un reporte de un alumno"+texto;
    }
}
