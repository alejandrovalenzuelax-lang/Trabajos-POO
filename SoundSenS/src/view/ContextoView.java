package view;

import controller.ControladorAplicacion;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cancion;
import javafx.geometry.Insets;

import java.io.File;
import java.io.IOException;

public class ContextoView {

    private final Stage stage;
    private final ControladorAplicacion controlador;

    public ContextoView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar(){
        Label titulo = new Label("Contexto");

        TextArea areaContexto = new TextArea();
        areaContexto.setEditable(false);
        areaContexto.setWrapText(true);
        areaContexto.setPrefSize(400, 450);

        Label mensaje = new Label();

        Cancion cancionActual = controlador.obtenerCancionActual();

        ImageView portada = new ImageView();
        portada.setFitWidth(300);
        portada.setFitHeight(300);
        portada.setPreserveRatio(true);

        File archivoAlbum = new File(cancionActual.getRutaAlbum());

        if (archivoAlbum.isFile()) {

            Image imagen = new Image(archivoAlbum.toURI().toString());
            portada.setImage(imagen);
        }else {
            mensaje.setText("No se encontro la portada");
        }

        VBox panelContexto = new VBox(10);
        panelContexto.setAlignment(Pos.CENTER);

        panelContexto.getChildren().addAll(
                titulo,
                areaContexto,
                mensaje
        );



        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(e -> {
            controlador.mostrarReproductor();
        });

        try{
            String contexto = controlador.obtenerContextoCancionActual();
            areaContexto.setText(contexto);
        } catch (IOException | IllegalArgumentException e) {
            mensaje.setText(e.getMessage());
        }

        Label tituloCancion = new Label(cancionActual.getTitulo());
        Label artista = new Label(cancionActual.getArtista());

        VBox panelCentro = new VBox(10);
        panelCentro.setAlignment(Pos.CENTER);

        panelCentro.getChildren().addAll(
                portada,
                tituloCancion,
                artista,
                botonVolver
        );

        BorderPane raiz = new BorderPane();
        BorderPane.setMargin(panelContexto, new Insets(0, 0, 0, 30));

        raiz.setPadding( new Insets(10));
        raiz.setRight(panelContexto);
        raiz.setCenter(panelCentro);
        Scene scene = new Scene(raiz, 1000, 600);

        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSenS - Contexto");
        stage.show();


    }


}
