package view;

import controller.ControladorAplicacion;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Usuario;

public class InicioView {

    private final Stage stage;
    private final ControladorAplicacion controlador;

    public InicioView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar() {

        Usuario usuario = controlador.getUsuarioActual();

        Label saludo = new Label("Hola, " + usuario.getNombreUsuario());

        saludo.getStyleClass().add("titulo");

        Button botonAbrirReproductor = new Button("Abrir reproductor");

        Button botonBuscarCanciones = new Button("Buscar canciones");

        Button botonMisPlaylists = new Button("Mis playlists");

        Button botonMiPerfil = new Button("Mi perfil");

        Button botonEstadisticas = new Button("Estadísticas");

        Button[] botonesMenu = {
                botonAbrirReproductor,
                botonBuscarCanciones,
                botonMisPlaylists,
                botonMiPerfil,
                botonEstadisticas
        };

        for (Button boton : botonesMenu) {
            boton.getStyleClass().add("boton-menu");
        }

        botonAbrirReproductor.setOnAction(evento -> {
            controlador.mostrarReproductor();
        });

        botonBuscarCanciones.setOnAction(evento -> {
            controlador.mostrarBusqueda();
        });

        botonMisPlaylists.setOnAction(evento -> {
            controlador.mostrarPlaylists();
        });

        botonMiPerfil.setOnAction(evento -> {
            controlador.mostrarPerfil();
        });

        botonEstadisticas.setOnAction(evento -> {
            controlador.mostrarEstadisticas();
        });

        GridPane menu = new GridPane();

        menu.setHgap(18);
        menu.setVgap(18);
        menu.setAlignment(Pos.CENTER);

        menu.add(botonAbrirReproductor, 0, 0);
        menu.add(botonBuscarCanciones, 1, 0);

        menu.add(botonMisPlaylists, 0, 1);
        menu.add(botonMiPerfil, 1, 1);

        menu.add(botonEstadisticas, 0, 2, 2, 1);

        GridPane.setHalignment(botonEstadisticas, HPos.CENTER);

        VBox contenedor = new VBox(28);

        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(40));

        contenedor.getChildren().addAll(
                saludo,
                menu
        );

        Scene scene = new Scene(contenedor, 1000, 600);

        EstilosAplicacion.aplicar(scene);

        stage.setScene(scene);
        stage.setTitle("SoundSenS - Inicio");
        stage.show();
    }
}