package view;

import controller.ControladorAplicacion;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Usuario;

public class PerfilView {

    private final Stage stage;
    private final ControladorAplicacion controlador;

    public PerfilView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar() {

        Label titulo = new Label(" Mi Perfil");
        Label nombreUsuario = new Label("Nombre Usuario");
        Label mensaje = new Label();

        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(e -> {
            controlador.mostrarInicio();
        });

        Button botonCerrarSesion = new Button("Cerrar sesion");
        botonCerrarSesion.setOnAction(e -> {
            controlador.cerrarSesion();
        });

        try{
            Usuario usuario = controlador.getUsuarioActual();

            nombreUsuario.setText("Usuario: " + usuario.getNombreUsuario());

        }catch (IllegalStateException e){
            mensaje.setText(e.getMessage());
        }

        VBox contenedor = new VBox(15);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(30));

        contenedor.getChildren().addAll(
                titulo,
                nombreUsuario,
                mensaje,
                botonVolver,
                botonCerrarSesion
        );

        Scene scene = new Scene(contenedor,1000,600);
        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSenS - Mi Perfil");
        stage.show();

    }
}
