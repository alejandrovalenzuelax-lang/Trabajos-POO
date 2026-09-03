public class CalculadoraColegiatura {

    public static Double calcular(Alumno alumno, EstrategiaDescuento descuento){
        return descuento.aplicarDescuento(alumno.colegiatura);
    }
}
