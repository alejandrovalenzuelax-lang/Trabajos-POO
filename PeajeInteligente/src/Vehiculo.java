public abstract class Vehiculo {

    final private String matricula;
    final private String modelo;
    final private Double pesoToneladas;


    protected Vehiculo(String matricula, String modelo, Double pesoToneladas) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.pesoToneladas = pesoToneladas;
    }

    public String getMatricula() {
        return matricula;
    }

    public Double getPesoToneladas() {
        return pesoToneladas;
    }

    public String getModelo() {
        return modelo;
    }
}
