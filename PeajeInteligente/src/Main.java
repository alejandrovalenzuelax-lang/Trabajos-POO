//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Precargar lista negra
        ControlSeguridad.agregarMatriculaRobada("XYZ123");
        ControlSeguridad.agregarMatriculaRobada("ABC987");

        // 2. Crear caseta
        CasetaPeaje caseta = new CasetaPeaje("CAS-001");

        // 3. Crear calculador de peaje regular
        CalculoPeaje peajeRegular = new PeajeRegular();

        // 4. Crear vehículos de prueba
        AutoParticular auto1 = new AutoParticular(
                "AAA111",
                "Toyota Corolla",
                1.5,
                4
        );

        CamionCarga camion1 = new CamionCarga(
                "TRK555",
                "Volvo FH",
                8.0,
                4
        );

        AutoParticular autoRobado = new AutoParticular(
                "XYZ123",
                "Nissan Versa",
                1.3,
                2
        );

        System.out.println("=== Registrando pasos ===");

        caseta.registrarPaso(auto1, peajeRegular);
        caseta.registrarPaso(camion1, peajeRegular);
        caseta.registrarPaso(autoRobado, peajeRegular);

        System.out.println();
        System.out.println("=== Historial ===");
        caseta.imprimirHistorial();

        System.out.println();
        System.out.println("=== Recaudacion ===");
        caseta.imprimirReporteRecaudacion();


    }
}