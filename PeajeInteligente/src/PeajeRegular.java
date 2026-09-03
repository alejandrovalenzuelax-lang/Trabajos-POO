public class PeajeRegular implements CalculoPeaje{




    @Override
    public Double calcularTarifa(Vehiculo vehiculo) {
        if (vehiculo instanceof AutoParticular ){
            return 100.00;
        }
        if (vehiculo instanceof CamionCarga){
            return ((CamionCarga) vehiculo).getNoEjes()*150.00;
        }
        throw new IllegalArgumentException("Tipo de vehiculo no soportado");
    }
}
