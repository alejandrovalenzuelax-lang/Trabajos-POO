package view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Cancion;
import javafx.stage.Stage;

import service.ReproductorMusica;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import java.io.File;
import controller.ControladorAplicacion;

import javafx.scene.control.ChoiceDialog;
import model.Playlist;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Slider;



public class ReproductorView {

    private final Stage stage;
    private final ReproductorMusica reproductor;
    private final ControladorAplicacion controlador;

    public ReproductorView(Stage stage, ReproductorMusica reproductor, ControladorAplicacion controlador) {
        this.stage = stage;
        this.reproductor = reproductor;
        this.controlador = controlador;
    }

    public void mostrar(){

        Label titulo = new Label();
        Label artista = new Label();
        Label mensaje = new Label();

        ImageView portada = new ImageView();

        portada.setFitHeight(250);
        portada.setFitWidth(250);
        portada.setPreserveRatio(true);


        try{
            if (!reproductor.hayCancionCargada()) {
                reproductor.cargarCancion(0);
            }
            actualizarInformacion(titulo,artista,portada,mensaje);

        }catch (IllegalArgumentException | IllegalStateException e){
            mensaje.setText(e.getMessage());
        }

        Button botonPlay = new Button("Play");
        Button botonPause = new Button("Pause");
        Button botonVolver = new Button("Volver al inicio");


        botonPlay.setOnAction(evento -> {
            try {
                reproductor.reproducirCancion();

            } catch (IllegalStateException e) {
                mensaje.setText(e.getMessage());
            }
        });

        botonPause.setOnAction(evento -> {
            try {
                reproductor.pausarCancion();
            }catch (IllegalStateException e) {
                mensaje.setText(e.getMessage());
            }
        });

        botonVolver.setOnAction(evento -> {
            controlador.mostrarInicio();
        });

        Button botonAnterior = new Button("Anterior");
        Button botonSiguiente = new Button("Siguiente");

        botonSiguiente.setOnAction(evento -> {
            try {
                reproductor.siguienteCancion();
                actualizarInformacion(titulo,artista,portada,mensaje);
            }catch (IllegalStateException e) {
                mensaje.setText(e.getMessage());
            }
        });

        botonAnterior.setOnAction(evento -> {
            try {
                reproductor.anteriorCancion();
                actualizarInformacion(titulo,artista,portada,mensaje);
            }catch (IllegalStateException e) {
                mensaje.setText(e.getMessage());
            }
        });

        Button botonAdelantar = new Button("+10 s");
        Button botonRetrasar = new Button("-10 s");

        botonAdelantar.setOnAction(evento -> {
            try {
                reproductor.adelantarCancion(10);
            }catch (IllegalStateException | IllegalArgumentException e) {
                mensaje.setText(e.getMessage());
            }
        });

        botonRetrasar.setOnAction(evento -> {
            try {
                reproductor.atrasarCancion(10);
            }catch (IllegalStateException | IllegalArgumentException e) {
                mensaje.setText(e.getMessage());
            }
        });


        Slider volumen = new Slider(0, 100, 100);

        volumen.valueProperty().addListener(
                (observable, valorAnterior, valorNuevo) -> {

                    double volumenConvertido = valorNuevo.doubleValue() / 100.0;

                    reproductor.cambiarVolumen(volumenConvertido);
                }
        );

        Button botonLyrics = new Button("Lyrics");
        Button botonContexto = new Button("Contexto");
        Button botonVideo = new Button("Video");

        botonLyrics.setOnAction(evento -> {
            controlador.mostrarLyrics();
        });

        botonContexto.setOnAction(evento -> {
            controlador.mostrarContexto();
        });

        botonVideo.setOnAction(evento -> {
            controlador.mostrarVideo();
        });

        Button botonAgregarPlaylist = new Button("Agregar a playlist");

        botonAgregarPlaylist.setOnAction(evento -> {
            List<Playlist> playlists = controlador.obtenerPlaylists();

            if (playlists.isEmpty()) {
                mensaje.setText("Primero debes crear una playlist");
                return;
            }

            ChoiceDialog<Playlist> dialogo = new ChoiceDialog<>(playlists.get(0), playlists);

            dialogo.setTitle("Agregar playlist");
            dialogo.setHeaderText("Selecciona una playlist");
            dialogo.setContentText("Playlist: ");

            Optional<Playlist> seleccion = dialogo.showAndWait();

            if (seleccion.isEmpty()){
                return;
            }

            try{
                controlador.agregarCancionActualAPlaylist(seleccion.get());

                mensaje.setText("Cancion agregada a " + seleccion.get().getNombre());
            }catch (IOException | IllegalArgumentException | IllegalStateException ex){
                mensaje.setText(ex.getMessage());
            }


        });

        HBox botonesInformacion = new HBox(10);
        botonesInformacion.setAlignment(Pos.CENTER);

        botonesInformacion.getChildren().addAll(
                botonLyrics,
                botonContexto,
                botonVideo
        );

        HBox controles = new HBox();
        controles.setSpacing(10);
        controles.setAlignment(Pos.CENTER);

        Label textoVolumen = new Label("Volumen");

        controles.getChildren().addAll(
                botonAnterior,
                botonRetrasar,
                botonPlay,
                botonPause,
                botonAdelantar,
                botonSiguiente,
                botonAgregarPlaylist
        );

        HBox controlVolumen = new HBox();
        controlVolumen.setSpacing(10);
        controlVolumen.setAlignment(Pos.CENTER);

        controlVolumen.getChildren().addAll(
                textoVolumen,
                volumen
        );

        VBox contenedor = new VBox();
        contenedor.setPadding(new Insets(30));
        contenedor.setSpacing(15);
        contenedor.setAlignment(Pos.CENTER);

        contenedor.getChildren().addAll(
                botonVolver,
                portada,
                titulo,
                artista,
                controles,
                controlVolumen,
                mensaje,
                botonesInformacion
        );

        Scene scene = new Scene(contenedor,1000,600);
        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSenS - Reproductor");
        stage.show();

    }

    private void actualizarInformacion(Label titulo, Label artista, ImageView portada, Label mensaje){
        Cancion cancionActual = reproductor.getCancionActual();

        titulo.setText(cancionActual.getTitulo());
        artista.setText(cancionActual.getArtista());

        File archivoAlbum = new File(cancionActual.getRutaAlbum());

        if (archivoAlbum.isFile()) {
            Image imagenAlbum = new Image(archivoAlbum.toURI().toString());
            portada.setImage(imagenAlbum);
            mensaje.setText("");

        }else {
            portada.setImage(null);
            mensaje.setText("No se encontró la portada");
        }

    }


}
