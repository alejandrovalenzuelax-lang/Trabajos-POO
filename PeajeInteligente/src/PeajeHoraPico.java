public class PeajeHoraPico implements CalculoPeaje{


    @Override
    public Double calcularTarifa(Vehiculo vehiculo) {
        if (vehiculo instanceof AutoParticular ){
            return 150.00;
        }
        if (vehiculo instanceof CamionCarga){
            return (((CamionCarga) vehiculo).getNoEjes()*150.00)+(((((CamionCarga) vehiculo).getNoEjes()*150)*20)/100);
        }
        throw new IllegalArgumentException("Tipo de vehiculo no soportado");
    }
}
