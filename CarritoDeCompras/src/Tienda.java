import java.util.HashMap;
import java.util.Map;

public class Tienda {

    Map<String, Integer> productos;

    public Tienda() {
        this.productos = new HashMap<>();
        productos.put("Iphone",5);
        productos.put("Fundas",3);
        productos.put("Audifonos",0);
    }

    public void realizarPedido(String producto,int cantidad) throws SinStockException,StockInsuficienteException{

        if ( productos.get(producto) == 0){
            throw new SinStockException("Error: No hay stock de este producto...");

        } else if (cantidad > productos.get(producto)){
            throw new StockInsuficienteException("Stock Insuficiente...");

        }else {
            System.out.println("Pedido realizado...");
        }

    }


}
