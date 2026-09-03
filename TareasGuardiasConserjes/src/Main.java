public class Main {
    public static void main(String[] args) {

        AdministradorTareas administrador = new AdministradorTareas();

        System.out.println("=== Tareas pendientes al inicio ===");
        administrador.mostrarTareasPendientes();

        System.out.println();

        System.out.println("=== Ver siguiente tarea sin tareas ===");
        administrador.verSiguienteTarea();

        System.out.println();

        System.out.println("=== Asignar tarea sin tareas ===");
        administrador.asignarSiguienteTarea("Pedro");

        System.out.println();

        System.out.println("=== Agregando tareas ===");
        administrador.agregarTarea("Limpiar laboratorio 3");
        administrador.agregarTarea("Reparar proyector aula 5");
        administrador.agregarTarea("Revisar baños del edificio B");
        administrador.agregarTarea("Cambiar focos de biblioteca");

        System.out.println();

        System.out.println("=== Tareas pendientes ===");
        administrador.mostrarTareasPendientes();

        System.out.println();

        System.out.println("=== Ver siguiente tarea ===");
        administrador.verSiguienteTarea();

        System.out.println();

        System.out.println("=== Asignando tareas ===");
        administrador.asignarSiguienteTarea("Pedro");
        administrador.asignarSiguienteTarea("Luis");

        System.out.println();

        System.out.println("=== Tareas pendientes despues de asignar 2 ===");
        administrador.mostrarTareasPendientes();

        System.out.println();

        System.out.println("=== Ver siguiente tarea actual ===");
        administrador.verSiguienteTarea();

        System.out.println();

        System.out.println("=== Asignando el resto ===");
        administrador.asignarSiguienteTarea("Marta");
        administrador.asignarSiguienteTarea("Jose");
        administrador.asignarSiguienteTarea("Ana");

        System.out.println();

        System.out.println("=== Tareas pendientes al final ===");
        administrador.mostrarTareasPendientes();
    }
}