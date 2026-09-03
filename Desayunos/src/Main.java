//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Alimento ordenSola = new AlmuerzoBase();
        Alimento ordenConHuevo = new AlmuerzoBase();
        Alimento ordenConPollo = new AlmuerzoBase();
        Alimento ordenConPolloHuevo = new AlmuerzoBase();

        ordenConHuevo = new ConHuevo(ordenConHuevo);
        System.out.println(ordenConHuevo.getDetalle());
        System.out.println(ordenConHuevo.getPrecio());
        ordenConPollo = new ConPollo(ordenConPollo);
        System.out.println(ordenConPollo.getDetalle());
        System.out.println(ordenConPollo.getPrecio());
        ordenConPolloHuevo = new ConPollo(ordenConPolloHuevo);
        ordenConPolloHuevo = new ConHuevo(ordenConPolloHuevo);
        System.out.println(ordenConPolloHuevo.getDetalle());
        System.out.println(ordenConPolloHuevo.getPrecio());



    }
}