public class CorreoTutor implements CanalComunicacion{

    @Override
    public String enviarAlerta(String texto) {
        return "Este correo es un reporte acerca de un Alumno"+texto;
    }
}
