public class ReporteDisciplina {
    final String NombreAlumno="Jonathan";
    final String Motivo="Reporte..." ;

    public void enviarMensaje(int gravedad){
        CoordinadorEscolar obj1 = new CoordinadorEscolar();

        if (gravedad == 1){
            System.out.println(obj1.returnMessage(new SmsDirector(),"hola"));
        }else{
            System.out.println(obj1.returnMessage(new CorreoTutor(),"hola"));
        }
    }
}
