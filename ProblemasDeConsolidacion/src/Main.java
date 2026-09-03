
public class Main {
    public static void main(String[] args) {

        ControlEscolar control = new ControlEscolar();

        Alumno[] alumnos = {
                new Alumno("A001", "Ana Lopez", "Matematicas"),
                new Alumno("A002", "Luis Perez", "Programacion"),
                new Alumno("A003", "Maria Garcia", "Historia"),
                new Alumno("A001", "Ana Lopez", "Matematicas"), // duplicado
                new Alumno("A004", "Carlos Ruiz", "Fisica"),
                new Alumno("A002", "Luis Perez", "Programacion"), // duplicado
                new Alumno("A005", "Sofia Torres", "Quimica")
        };

        for (Alumno alumno : alumnos) {
            try {
                control.registrarLlegada(alumno);
                System.out.println("Registrado: " + alumno.getMatricula() + " - " + alumno.getNombre());
            } catch (ExistenteException e) {
                System.out.println("Duplicado ignorado: " + alumno.getMatricula() + " - " + alumno.getNombre());
            }
        }
    }
}