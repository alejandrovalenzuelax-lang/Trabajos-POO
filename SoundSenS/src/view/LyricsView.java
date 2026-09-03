package view;

import controller.ControladorAplicacion;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cancion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import java.io.File;
import javafx.geometry.Insets;

import java.io.IOException;

public class LyricsView {

    private final Stage stage;
    private final ControladorAplicacion controlador;

    public LyricsView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar(){

        Label titulo = new Label("Lyrics");

        TextArea areaLyrics = new TextArea();
        areaLyrics.setEditable(false);
        areaLyrics.setWrapText(true);
        areaLyrics.setPrefSize(400,450);

        Button botonVolver = new Button("Volver");

        botonVolver.setOnAction(e -> {
            controlador.mostrarReproductor();
        });

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

        VBox panelLyrics = new VBox(10);
        panelLyrics.setAlignment(Pos.CENTER);

        panelLyrics.getChildren().addAll(
                titulo,
                areaLyrics,
                mensaje
        );

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



        try{
            String letra = controlador.obtenerLyricsCancionActual();
            areaLyrics.setText(letra);
        } catch (IOException | IllegalArgumentException e) {
            mensaje.setText(e.getMessage());
        }



        BorderPane raiz = new BorderPane();
        BorderPane.setMargin(panelLyrics, new Insets(0, 30, 0, 0));

        raiz.setPadding( new Insets(30));
        raiz.setLeft(panelLyrics);
        raiz.setCenter(panelCentro);

        Scene scene = new Scene(raiz, 1000, 600);
        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSens - Lyrics");
        stage.show();


    }


}
