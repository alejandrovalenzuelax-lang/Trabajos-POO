//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InventarioRobotica inventario = new InventarioRobotica();

        Componente sensor1 = new Componente("Sensor ultrasonico", "S001", true);
        Componente sensor2 = new Componente("Sensor infrarrojo", "S002", false);
        Componente sensor3 = new Componente("Sensor de color", "S003", true);

        Componente motor1 = new Componente("Motor DC", "M001", true);
        Componente motor2 = new Componente("Servomotor", "M002", true);

        Componente micro1 = new Componente("Arduino Uno", "MC001", false);
        Componente micro2 = new Componente("ESP32", "MC002", true);

        inventario.agregarComponente("Sensores", sensor1);
        inventario.agregarComponente("Sensores", sensor2);
        inventario.agregarComponente("Sensores", sensor3);

        inventario.agregarComponente("Motores", motor1);
        inventario.agregarComponente("Motores", motor2);

        inventario.agregarComponente("Microcontroladores", micro1);
        inventario.agregarComponente("Microcontroladores", micro2);

        System.out.println("=== Componentes por categoria: Sensores ===");
        try {
            inventario.mostrarComponentesPorCategoria("Sensores");
        } catch (CategoriaInexistenteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("=== Resumen por categoria ===");
        inventario.mostrarResumenPorCategoria();

        System.out.println();

        System.out.println("=== Consultas de disponibilidad ===");

        try {
            boolean disponible = inventario.consultarDisponibilidad("Sensores", "S001");
            System.out.println("S001 disponible: " + disponible);
        } catch (CategoriaInexistenteException | CodigoInexistenteErroneoException e) {
            System.out.println(e.getMessage());
        }

        try {
            boolean disponible = inventario.consultarDisponibilidad("Sensores", "S002");
            System.out.println("S002 disponible: " + disponible);
        } catch (CategoriaInexistenteException | CodigoInexistenteErroneoException e) {
            System.out.println(e.getMessage());
        }

        try {
            boolean disponible = inventario.consultarDisponibilidad("Sensores", "S999");
            System.out.println("S999 disponible: " + disponible);
        } catch (CategoriaInexistenteException | CodigoInexistenteErroneoException e) {
            System.out.println(e.getMessage());
        }

        try {
            boolean disponible = inventario.consultarDisponibilidad("Baterias", "B001");
            System.out.println("B001 disponible: " + disponible);
        } catch (CategoriaInexistenteException | CodigoInexistenteErroneoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("=== Categoria inexistente al mostrar ===");
        try {
            inventario.mostrarComponentesPorCategoria("Herramientas");
        } catch (CategoriaInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }
}