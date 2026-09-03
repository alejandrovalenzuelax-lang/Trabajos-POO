public class CamionCarga extends Vehiculo{

    final private Integer noEjes;

    public CamionCarga(String matricula, String modelo, Double pesoToneladas, Integer noEjes) {
        super(matricula, modelo, pesoToneladas);
        this.noEjes = noEjes;
    }

    public Integer getNoEjes() {
        return noEjes;
    }



}
