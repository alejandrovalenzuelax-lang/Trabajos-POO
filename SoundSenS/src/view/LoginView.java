package view;

import controller.ControladorAplicacion;
import exception.CredencialesInvalidasException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class LoginView {

    private final Stage stage;
    private final ControladorAplicacion controlador;

    public LoginView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar() {

        Label titulo = new Label("Iniciar sesión");

        TextField campoUsuario = new TextField();
        campoUsuario.setPromptText("Nombre de usuario");


        PasswordField campoContrasena = new PasswordField();
        campoContrasena.setPromptText("Contraseña");

        campoUsuario.setMinSize(320, 40);
        campoUsuario.setPrefSize(320, 40);
        campoUsuario.setMaxSize(320, 40);

        campoContrasena.setMinSize(320, 40);
        campoContrasena.setPrefSize(320, 40);
        campoContrasena.setMaxSize(320, 40);

        Label mensaje = new Label();

        Button botonIniciarSesion = new Button("Iniciar sesión");
        Button botonRegistrar = new Button("Crear cuenta");

        botonIniciarSesion.setDefaultButton(true);

        botonIniciarSesion.setOnAction(evento -> {
            String nombre = campoUsuario.getText();
            String contrasena = campoContrasena.getText();

            try {
                controlador.iniciarSesion(nombre, contrasena);

            } catch (CredencialesInvalidasException e) {
                mensaje.setText(e.getMessage());
            }
        });

        botonRegistrar.setOnAction(evento -> {
            controlador.mostrarRegistro();
        });

        VBox contenedor = new VBox();

        contenedor.setSpacing(10);
        contenedor.setAlignment(Pos.CENTER);

        contenedor.getChildren().addAll(
                titulo,
                campoUsuario,
                campoContrasena,
                botonIniciarSesion,
                botonRegistrar,
                mensaje
        );

        Scene scene = new Scene(contenedor, 1000, 600);
        EstilosAplicacion.aplicar(scene);

        stage.setScene(scene);
        stage.setTitle("SoundSenS - Iniciar sesión");
        stage.show();
    }
}