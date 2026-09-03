import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Cancion;
import service.CargadorCanciones;
import service.GestorUsuarios;
import service.ReproductorMusica;
import view.LoginView;
import controller.ControladorAplicacion;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        try {
            GestorUsuarios gestorUsuarios = new GestorUsuarios();

            CargadorCanciones cargadorCanciones = new CargadorCanciones();

            ArrayList<Cancion> canciones = cargadorCanciones.cargarCanciones();

            ReproductorMusica reproductor = new ReproductorMusica(canciones);

            ControladorAplicacion controlador = new ControladorAplicacion(stage, gestorUsuarios, reproductor);
            controlador.mostrarLogin();

        } catch (IOException | IllegalArgumentException e) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setTitle("Error");
            alerta.setHeaderText("No se pudo iniciar SoundSenS");

            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}