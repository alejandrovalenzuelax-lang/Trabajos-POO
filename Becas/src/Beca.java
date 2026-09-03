public abstract class Beca {
    Long diasVigenciaRestantes;

    public Beca(Long diasVigenciaRestantes) {
        this.diasVigenciaRestantes = diasVigenciaRestantes;
    }

    public abstract Boolean esValida();
}
