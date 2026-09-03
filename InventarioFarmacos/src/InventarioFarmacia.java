import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InventarioFarmacia {

    HashSet<String> codigosBarras;
    Map<String, Medicamento> catalogo;


    public InventarioFarmacia() {
        this.codigosBarras = new HashSet<>();
        this.catalogo = new HashMap<>();
    }

    public void registraMedicamento(Medicamento medicamento) throws MedicamentoDuplicadoException{
        if (codigosBarras.contains(medicamento.getCodigoDeBarras())){
            throw new MedicamentoDuplicadoException("Error: Este medicamento ya existe...");
        }else{
            codigosBarras.add(medicamento.getCodigoDeBarras());
            catalogo.put(medicamento.getCodigoDeBarras(),medicamento);
            System.out.println("Producto registrado con exito...");
        }
    }

    public void buscarMedicamento (Medicamento medicamento){
        if(codigosBarras.contains(medicamento.getCodigoDeBarras())){
            System.out.println("Producto existente...");
        }else{
            System.out.println("Este productos no existe...");
        }
    }

    public void mostrarInventario(){
        for (Map.Entry<String,Medicamento> entrada: catalogo.entrySet()){
            System.out.println(entrada.getKey() + " ---> " + entrada.getValue());
        }
    }



}
