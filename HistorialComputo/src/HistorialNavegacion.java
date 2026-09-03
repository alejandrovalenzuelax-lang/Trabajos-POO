import java.util.LinkedList;

public class HistorialNavegacion {

    private final LinkedList<String> historial;

    public HistorialNavegacion() {
        this.historial = new LinkedList<>();
    }

    public void visitarPagina(String url){
        historial.push(url);
    }

    public void mostrarHistorial(){
        if (historial.isEmpty()){
            System.out.println("Historial vacio...");
        }else {
            for ( int i=0; i<historial.size(); i++){
                System.out.println(historial.get(i));
            }
        }
    }

    public void irAtras(){
        if (historial.isEmpty()){
            System.out.println("Historial vacio...");
        } else if (historial.size() == 1) {
            System.out.println("No hay pagina anterior...");
        } else {
            historial.pollFirst();
        }
    }

    public String paginaActual(){
        if (historial.isEmpty()){
            return null;
        }
        return historial.peek();

    }

}
