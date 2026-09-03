//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RevisionDocumentos documentos = new RevisionDocumentos(true,true);
        ValidacionPago pago = new ValidacionPago(true);
        ComiteAcademico promedio = new ComiteAcademico(10);

        RevisionDocumentos documentos2 = new RevisionDocumentos(true,true);
        ValidacionPago pago2= new ValidacionPago(false);
        ComiteAcademico promedio2= new ComiteAcademico(5);

        documentos.setSiguienteFiltro(pago);
        pago.setSiguienteFiltro(promedio);

        documentos2.setSiguienteFiltro(pago2);
        pago2.setSiguienteFiltro(promedio2);

        String nombre1 = LimpiarNombre.limpiar("JUAN PEREZ");
        boolean resultado1 = documentos.validar(nombre1);

        String nombre2 = LimpiarNombre.limpiar("MARIA LOPEZ");
        boolean resultado2 = documentos2.validar(nombre2);

        if (resultado1){
            System.out.println(nombre1+" Admitido...");
        }else{
            System.out.println(nombre1+" Rechazado...");
        }
        if (resultado2){
            System.out.println(nombre2+" Admitido...");
        }else{
            System.out.println(nombre2+" Rechazado...");
        }


    }
}