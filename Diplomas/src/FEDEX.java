public class FEDEX implements EmpresaPaqueteria {

    private final String nombreEmpresa="FEDEX";


    @Override
    public Double costoEnvio(PaqueteDiploma paquete, DireccionDestino destino) {
        return (paquete.getAlto() * paquete.getPeso()*destino.getCodigoPostal());
    }


    @Override
    public String getEmpresa() {
        return nombreEmpresa;
    }
}
