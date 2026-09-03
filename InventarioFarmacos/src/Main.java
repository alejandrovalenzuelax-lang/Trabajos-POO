public class Main {
    public static void main(String[] args) {

        InventarioFarmacia inventario = new InventarioFarmacia();

        Medicamento medicamento1 = new Medicamento("ABC123", "Paracetamol", "2027-05-10", 50);
        Medicamento medicamento2 = new Medicamento("XYZ999", "Ibuprofeno", "2026-11-20", 30);
        Medicamento medicamento3 = new Medicamento("LMN456", "Amoxicilina", "2028-01-15", 20);

        // Este tiene codigo repetido a proposito
        Medicamento medicamentoRepetido = new Medicamento("ABC123", "Paracetamol Duplicado", "2029-01-01", 100);

        try {
            inventario.registraMedicamento(medicamento1);
            inventario.registraMedicamento(medicamento2);
            inventario.registraMedicamento(medicamento3);

            inventario.registraMedicamento(medicamentoRepetido);

        } catch (MedicamentoDuplicadoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Buscando medicamentos:");
        inventario.buscarMedicamento(medicamento1);

        Medicamento medicamentoNoRegistrado = new Medicamento("NOEXISTE", "Aspirina", "2027-09-09", 10);
        inventario.buscarMedicamento(medicamentoNoRegistrado);

        System.out.println();
        System.out.println("Inventario actual:");
        inventario.mostrarInventario();
    }
}