public class DHL implements EmpresaPaqueteria{

    private final String nombreEmpresa = "DHL";

    @Override
    public String getEmpresa() {
        return nombreEmpresa;
    }

    @Override
    public Double costoEnvio(PaqueteDiploma paquete, DireccionDestino destino) {
        return (paquete.getAlto() * paquete.getPeso()*destino.getCodigoPostal());
    }


}
