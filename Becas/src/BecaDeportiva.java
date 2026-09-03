public class BecaDeportiva extends Beca{


    public BecaDeportiva(Long diasVigenciaRestantes) {
        super(diasVigenciaRestantes);
    }

    @Override
    public Boolean esValida() {
        if (this.diasVigenciaRestantes > 0){
            return true;
        }else {
            return false;
        }
    }
}
