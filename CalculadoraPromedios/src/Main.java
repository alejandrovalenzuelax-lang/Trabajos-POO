import javax.sound.midi.Soundbank;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner sacnner = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de alumnos: ");
        int cantidadAlumnos = sacnner.nextInt();
        int suma = 0;

        for (int alumno = 0; alumno<cantidadAlumnos; alumno++){

            boolean calificacionValida = false;

            while(!calificacionValida){
                try {
                    System.out.println("Ingresa una calificacion: ");
                    int calificacion = sacnner.nextInt();

                    Calculadora.validarCalificacion(calificacion);
                    suma = suma + calificacion;
                    calificacionValida = true;

                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    System.out.println("Ingresa de nuevo la calificacion: ");
                }
            }

        }
        try{
            int promedio = Calculadora.calcularPromedio(suma,cantidadAlumnos);
            System.out.println("Promedio del grupo: "+ promedio);
        }catch (ArithmeticException e){
            System.out.println("No se puede calcular el promedio de un grupo vacio");
        }

    }
}