package view;

import controller.ControladorAplicacion;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cancion;
import java.util.ArrayList;


public class BusquedaView {

    private final Stage stage;
    private final ControladorAplicacion controlador;


    public BusquedaView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar() {

        Label titulo = new Label("Buscar canciones");

        TextField campoBusqueda = new TextField();
        campoBusqueda.setText("Titulo o Artista");

        Button botonBuscar = new Button("Buscar");
        Button botonVolver = new Button("Volver");


        Label mensaje = new Label();

        VBox contenedorResultados = new VBox();
        contenedorResultados.setSpacing(10);

        botonBuscar.setOnAction(e -> {
            contenedorResultados.getChildren().clear();
            String texto = campoBusqueda.getText();
            try{
                ArrayList<Cancion> resultados = controlador.buscarCanciones(texto);

                if (resultados.isEmpty()){
                    mensaje.setText("No se encontraron canciones");
                    return;
                }

                mensaje.setText("Resultados encontrados: " + resultados.size());

                for (Cancion cancion : resultados) {

                    Label informacion = new Label(cancion.getTitulo() + " - " + cancion.getArtista());

                    Button botonReproducir = new Button("Reproducir");

                    botonReproducir.setOnAction(eventoReproducir -> {
                        try{
                            controlador.reproducirCancion(cancion);
                        }catch (IllegalArgumentException | IllegalStateException exe){
                            mensaje.setText(exe.getMessage());
                        }
                    });

                    HBox filaResultado = new HBox(10);
                    filaResultado.setAlignment(Pos.CENTER_LEFT);

                    filaResultado.getChildren().addAll(
                            informacion,
                            botonReproducir
                    );

                    contenedorResultados.getChildren().add(filaResultado);

                }

            }catch (IllegalArgumentException ex){
                mensaje.setText(ex.getMessage());
            }
        });

        botonBuscar.setDefaultButton(true);

        botonVolver.setOnAction(e -> {
            controlador.mostrarInicio();
        });

        ScrollPane desplazamiento = new ScrollPane(contenedorResultados);
        desplazamiento.setFitToWidth(true);

        HBox barraBusqueda = new HBox();
        barraBusqueda.setAlignment(Pos.CENTER);
        barraBusqueda.getChildren().addAll(
                campoBusqueda,
                botonBuscar
        );

        VBox contenedor = new VBox(15);
        contenedor.setAlignment(Pos.CENTER);

        contenedor.getChildren().addAll(
                titulo,
                barraBusqueda,
                mensaje,
                desplazamiento,
                botonVolver
        );

        Scene scene = new Scene(contenedor, 1000, 600);
        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSenS - Buscar canciones");
        stage.show();


    }

}
