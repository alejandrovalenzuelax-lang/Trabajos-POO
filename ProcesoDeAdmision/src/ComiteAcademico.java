public class ComiteAcademico extends FiltroAdmision{
    int promedio;

    public ComiteAcademico(int promedio) {
        this.promedio = promedio;
    }

    @Override
    boolean validar(String nombre) {
        if (promedio > 7){
            System.out.println(nombre+"Promedio... Ok.");
            if (siguienteFiltro != null){
                return siguienteFiltro.validar(nombre);
            }else{
                System.out.println(nombre+"Registrado con exito...");
                return true;
            }
        }else{
            System.out.println(nombre+"Error: Promedio bajo...");
            return false;
        }
    }
}
