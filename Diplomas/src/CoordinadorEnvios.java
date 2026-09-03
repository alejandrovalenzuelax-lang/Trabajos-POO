public class CoordinadorEnvios {

    EmpresaPaqueteria paqueteria;
    DireccionDestino destino;
    PaqueteDiploma diploma;

    public String informacionEnvio(){
        return "Sera enviado por: "+paqueteria.getEmpresa()+" ,Con un costo de "+paqueteria.costoEnvio(diploma,destino)+" ,A la direccion: "+destino.getCodigoPostal();
    }

    public CoordinadorEnvios(DireccionDestino destino, EmpresaPaqueteria paqueteria, PaqueteDiploma diploma) {
        this.destino = destino;
        this.paqueteria = paqueteria;
        this.diploma = diploma;
    }
}
