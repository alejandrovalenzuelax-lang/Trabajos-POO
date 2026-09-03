public abstract class  FiltroAdmision {

    protected FiltroAdmision siguienteFiltro;

    abstract boolean validar(String nombre);

    public void setSiguienteFiltro(FiltroAdmision siguiente){
        this.siguienteFiltro = siguiente;
    }
}
