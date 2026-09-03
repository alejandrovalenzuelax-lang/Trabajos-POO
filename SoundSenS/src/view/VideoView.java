package view;

import controller.ControladorAplicacion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoView {

    private final Stage stage;
    private final ControladorAplicacion controlador;

    public VideoView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar () {

        Label titulo = new Label("Video");
        Label mensaje = new Label();

        MediaView vistaVideo = new MediaView();

        vistaVideo.setFitHeight(450);
        vistaVideo.setFitWidth(800);
        vistaVideo.setPreserveRatio(true);

        try{
            MediaPlayer mediaPlayer = controlador.prepararVideoActual();

            vistaVideo.setMediaPlayer(mediaPlayer);
        }catch (IllegalArgumentException | IllegalStateException e){
            mensaje.setText(e.getMessage());
        }

        Button botonPlay = new Button("Play");
        Button botonPause = new Button("Pause");
        Button botonVolver = new Button("Volver");

        botonPlay.setOnAction(e -> {
            try {
                controlador.reproducirVideo();
            }catch (IllegalStateException ex){
                mensaje.setText(ex.getMessage());
            }
        });

        botonPause.setOnAction(e -> {
            try {
                controlador.pausarVideo();
            }catch (IllegalStateException ex){
                mensaje.setText(ex.getMessage());
            }
        });

        botonVolver.setOnAction(e -> {
            controlador.cerrarVideo();
        });

        HBox controles = new HBox(10);
        controles.setAlignment(Pos.CENTER);

        controles.getChildren().addAll(
                botonPlay,
                botonPause,
                botonVolver
        );

        VBox contenedor = new VBox(10);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(30));

        contenedor.getChildren().addAll(
                titulo,
                vistaVideo,
                controles,
                mensaje
        );

        Scene scene = new Scene(contenedor,1000,600);
        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSenS - video");
        stage.show();

    }

}
