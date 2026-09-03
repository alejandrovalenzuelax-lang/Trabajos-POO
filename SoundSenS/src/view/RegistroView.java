package view;
import controller.ControladorAplicacion;
import exception.UsuarioYaExisteException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class RegistroView {

    private final Stage stage;
    private final ControladorAplicacion controlador;


    public RegistroView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar (){

        Label titulo = new Label("Crear Cuenta");

        TextField campoNombreUsuario = new TextField();
        campoNombreUsuario.setPromptText("Nombre");
        PasswordField campoContrasena = new PasswordField();
        campoContrasena.setPromptText("Contraseña");
        PasswordField campoVerificarContrasena = new PasswordField();
        campoVerificarContrasena.setPromptText("Confirmar Contraseña");
        Button botonRegistrar = new Button("Registrar");
        Button botonVolver = new Button("Volver");

        campoNombreUsuario.setPrefWidth(320);
        campoNombreUsuario.setMaxWidth(320);

        campoContrasena.setPrefWidth(320);
        campoContrasena.setMaxWidth(320);

        campoVerificarContrasena.setPrefWidth(320);
        campoVerificarContrasena.setMaxWidth(320);

        Label mensaje = new Label();



        botonRegistrar.setOnAction(evento -> {

            String nombre = campoNombreUsuario.getText();
            String contrasena = campoContrasena.getText();
            String confirmacion = campoVerificarContrasena.getText();

            if (nombre.isBlank() || contrasena.isBlank() || confirmacion.isBlank()) {

                mensaje.setText("Debes completar todos los campos");
                return;
            }

            if (!contrasena.equals(confirmacion)) {
                mensaje.setText("Las contrasenas no coinciden");
                return;
            }

            try {
                controlador.registrarUsuario(nombre, contrasena);

                mensaje.setText("Cuenta creada correctamente");
                campoNombreUsuario.clear();
                campoContrasena.clear();
                campoVerificarContrasena.clear();

            } catch (UsuarioYaExisteException | IOException | IllegalArgumentException  e) {
                mensaje.setText(e.getMessage());

            }


        });

        botonVolver.setOnAction(evento -> {
            controlador.mostrarLogin();

        });

        VBox contenedor = new VBox();

        contenedor.setSpacing(10);
        contenedor.setAlignment(Pos.CENTER);

        contenedor.getChildren().addAll(
                titulo,
                campoNombreUsuario,
                campoContrasena,
                campoVerificarContrasena,
                botonRegistrar,
                botonVolver,
                mensaje
        );

        Scene scene = new Scene(contenedor, 1000, 600);
        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSenS - Crear Cuenta");
        stage.show();


    }

}
