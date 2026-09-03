import java.util.ArrayList;
import java.util.List;

public class AdministradorTareas {

    private final List<String> tareasPendientes;

    public AdministradorTareas() {
        this.tareasPendientes = new ArrayList<>();
    }


    public void agregarTarea(String tarea){
        tareasPendientes.add(tarea);
    }

    public void asignarSiguienteTarea(String conserje){
        if (tareasPendientes.isEmpty()){
            System.out.println("No hay tareas pendientes...");
        }else {
            String tarea = tareasPendientes.remove(0);
            System.out.println(conserje+" Recibe: "+ tarea);
        }
    }

    public void mostrarTareasPendientes(){
        for (int i=0; i<tareasPendientes.size();i++){
            System.out.println(tareasPendientes.get(i));
        }
    }

    public void verSiguienteTarea(){
       if (tareasPendientes.isEmpty()){
           System.out.println("No hay siguiente tarea...");
       }else {
           System.out.println(tareasPendientes.get(0));
       }
    }

}
