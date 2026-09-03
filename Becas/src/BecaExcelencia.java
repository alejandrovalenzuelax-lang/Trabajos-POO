public class BecaExcelencia extends Beca {


    public BecaExcelencia(Long diasVigenciaRestantes) {
        super(diasVigenciaRestantes);
    }

    @Override
    public Boolean esValida() {
        return this.diasVigenciaRestantes>0 ? true : false;
    }
}
