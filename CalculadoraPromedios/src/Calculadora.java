public class Calculadora {


    public static void validarCalificacion(int calificacion){
        if (calificacion <0 || calificacion >10){
            throw new IllegalArgumentException("La calificacion debe estar entre 0 y 10");
        }
    }


    public static int calcularPromedio(int suma, int alumnos){
        return suma/alumnos;
    }


}
