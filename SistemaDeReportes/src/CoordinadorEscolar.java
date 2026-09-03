public class CoordinadorEscolar {

    public String returnMessage(CanalComunicacion obj, String msj){
        return obj.enviarAlerta(msj);
    }
}
