package view;

import controller.ControladorAplicacion;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Playlist;
import model.Cancion;

import java.io.IOException;

public class PlaylistView {

    private final Stage stage;
    private final ControladorAplicacion controlador;

    public PlaylistView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar(){
        Label titulo = new Label("Mis Playlist");
        Label tituloLista = new Label("Lista de Playlists");
        Label tituloCrear = new Label("Crear Playlist");
        Label tituloCanciones = new Label("Canciones de la playlist seleccionada");

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre de la nueva playlist");
        campoNombre.setMaxWidth(350);

        Button botonCrear = new Button("Crear");
        Button botonEliminar = new Button("Eliminar");
        Button botonVolver = new Button("Volver");

        Label mensaje = new Label();

        ObservableList<Playlist> playlistObservables = FXCollections.observableArrayList(controlador.obtenerPlaylists());
        ListView<Playlist> listaPlayLists = new ListView<>(playlistObservables);
        listaPlayLists.setPrefSize(400, 300);

        ObservableList<Cancion> cancionesObservables = FXCollections.observableArrayList();
        ListView<Cancion> listaCanciones = new ListView<>(cancionesObservables);
        listaCanciones.setPrefSize(400, 300);

        botonVolver.setOnAction(e -> {
            controlador.mostrarInicio();
        });

        botonCrear.setOnAction(e -> {

            String nombre = campoNombre.getText();

            try{
                Playlist playlistCreada = controlador.crearPlaylist(nombre);

                playlistObservables.add(playlistCreada);

                listaPlayLists.getSelectionModel().select(playlistCreada);

                campoNombre.clear();
                mensaje.setText("Playlist creada correctamente");

            }catch (IOException | IllegalArgumentException | IllegalStateException ex){
                mensaje.setText(ex.getMessage());
            }
        });

        botonEliminar.setOnAction(e -> {
            Playlist playlistSeleccionada = listaPlayLists.getSelectionModel().getSelectedItem();

            if (playlistSeleccionada == null){
                mensaje.setText("Debes seleccionar un playlist");
                return;
            }

            try {
                controlador.eliminarPlaylist(playlistSeleccionada.getNombre());

                playlistObservables.remove(playlistSeleccionada);
                mensaje.setText("Playlist eliminado correctamente");

            }catch (IOException | IllegalArgumentException | IllegalStateException ex){
                mensaje.setText(ex.getMessage());
            }
        });

        Button botonReproducir = new Button("Reproducir");
        Button botonEliminarCancion = new Button("Eliminar cancion");

        botonReproducir.setOnAction(e -> {
            Cancion cancionSeleccionada = listaCanciones.getSelectionModel().getSelectedItem();

            if (cancionSeleccionada == null){
                mensaje.setText("Debes seleccionar un cancion");
                return;
            }

            try{
                controlador.reproducirCancion(cancionSeleccionada);
            }catch (IllegalArgumentException | IllegalStateException ex){
                mensaje.setText(ex.getMessage());
            }

        });

        botonEliminarCancion.setOnAction(e -> {
            Playlist playlistSeleccionada = listaPlayLists.getSelectionModel().getSelectedItem();
            Cancion cancionSeleccionada = listaCanciones.getSelectionModel().getSelectedItem();

            if (playlistSeleccionada == null){
                mensaje.setText("Debes seleccionar un playlist");
                return;
            }
            if (cancionSeleccionada == null){
                mensaje.setText("Debes seleccionar un cancion");
                return;
            }

            try{
                controlador.eliminarCancionDePlaylist(playlistSeleccionada,cancionSeleccionada);
                cancionesObservables.remove(cancionSeleccionada);
                mensaje.setText("Cancion eliminada correctamente");
            }catch (IOException | IllegalArgumentException | IllegalStateException ex){
                mensaje.setText(ex.getMessage());
            }

        });

        listaPlayLists.getSelectionModel().selectedItemProperty().addListener((observable, anterior, seleccionada) -> {
            if (seleccionada == null){
                cancionesObservables.clear();
                return;
            }

            cancionesObservables.setAll(controlador.obtenerCancionesPlaylist(seleccionada));

        });

        VBox panelPlaylists = new VBox(10);
        panelPlaylists.setAlignment(Pos.CENTER);

        panelPlaylists.getChildren().addAll(
                tituloLista,
                listaPlayLists,
                botonEliminar,
                tituloCrear,
                campoNombre,
                botonCrear
        );

        VBox panelCanciones = new VBox(10);
        panelCanciones.setAlignment(Pos.CENTER);

        panelCanciones.getChildren().addAll(
                tituloCanciones,
                listaCanciones,
                botonReproducir,
                botonEliminarCancion
        );

        HBox panelContenido = new HBox(30);
        panelContenido.setAlignment(Pos.CENTER);

        panelContenido.getChildren().addAll(
                panelPlaylists,
                panelCanciones
        );

        VBox contenedor = new VBox(15);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(25));

        contenedor.getChildren().addAll(
                titulo,
                panelContenido,
                mensaje,
                botonVolver
        );

        Scene scene = new Scene(contenedor, 1000, 600);
        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSenS - Playlist");
        stage.show();

    }

}
