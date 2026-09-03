public class AutoParticular extends Vehiculo{

    final private Integer cantidadPasajeros;

    public AutoParticular(String matricula, String modelo, Double pesoToneladas, Integer cantidadPasajeros) {
        super(matricula, modelo, pesoToneladas);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }


}
