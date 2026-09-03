public class Medicamento {

     final private String codigoDeBarras;
     final private String nombre;
     final private String caducidad;
     final private int stock;

    public Medicamento(String codigoDeBarras, String nombre, String caducidad, int stock) {
        this.codigoDeBarras = codigoDeBarras;
        this.nombre = nombre;
        this.caducidad = caducidad;
        this.stock = stock;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCadudicidad() {
        return caducidad;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "codigoDeBarras='" + codigoDeBarras + '\'' +
                ", nombre='" + nombre + '\'' +
                ", caducidad='" + caducidad + '\'' +
                ", stock=" + stock +
                '}';
    }
}
