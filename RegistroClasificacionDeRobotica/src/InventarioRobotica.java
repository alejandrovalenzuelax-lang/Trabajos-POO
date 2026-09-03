import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventarioRobotica {

    private final Map<String, List<Componente>> inventario;

    public InventarioRobotica() {
        this.inventario = new HashMap<>();
    }

    public void agregarComponente(String categoria, Componente componente){
        inventario.putIfAbsent(categoria,new ArrayList<>());
        inventario.get(categoria).add(componente);
    }

    public void mostrarComponentesPorCategoria (String categoria) throws CategoriaInexistenteException{
        if( inventario.containsKey(categoria)){
            List<Componente> componentes = inventario.get(categoria);
            for (Componente componente : componentes){
                System.out.println(componente);
            }
        }else{
            throw new CategoriaInexistenteException("No existe esta categoria...");
        }
    }

    public void mostrarResumenPorCategoria(){
        for (Map.Entry<String, List<Componente>> entrada : inventario.entrySet()) {
            String categoria = entrada.getKey();
            List<Componente> componentes = entrada.getValue();

            System.out.println(categoria + ": " + componentes.size());
        }
    }

    public boolean consultarDisponibilidad(String categoria, String codigo) throws CodigoInexistenteErroneoException,CategoriaInexistenteException{
        if (inventario.containsKey(categoria)){
            List<Componente> componentes = inventario.get(categoria);
            for (Componente componente : componentes){
                if (componente.getCodigo().equals(codigo)){
                    return componente.isDisponible();
                }
            }
            throw new CodigoInexistenteErroneoException("Codigo Erroneo o Inexistente...");

        }else{
            throw new CategoriaInexistenteException("Categoria Erronea o Inexistente");
        }
    }

}
