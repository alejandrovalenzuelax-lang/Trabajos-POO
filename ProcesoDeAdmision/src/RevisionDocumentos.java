public class RevisionDocumentos extends FiltroAdmision {
    boolean actaDeNaciemiento;
    boolean certificadoPrepa;

    public RevisionDocumentos(boolean certificadoPrepa, boolean actaDeNaciemiento) {
        this.certificadoPrepa = certificadoPrepa;
        this.actaDeNaciemiento = actaDeNaciemiento;
    }

    @Override
    boolean validar(String nombre) {
        if (this.actaDeNaciemiento && this.certificadoPrepa){
            System.out.println(nombre+"Documentos... ok.");
            if(siguienteFiltro != null){
                return siguienteFiltro.validar(nombre);
            }else{
                System.out.println(nombre+" Ultimo Filtro, registro con exito.");
                return true;
            }
        }else{
            System.out.println(nombre+" Error:Documentos incompletos");
            return false;
        }
    }
}
