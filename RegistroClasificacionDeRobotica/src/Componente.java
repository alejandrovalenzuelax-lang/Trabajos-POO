public class Componente {

    private final String nombre;
    private final String codigo;
    private boolean disponible;

    public Componente(String nombre, String codigo, boolean disponible) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
