package view;

import javafx.scene.Scene;

import java.net.URL;

public class EstilosAplicacion {

    public static void aplicar(Scene scene) {

        if (scene == null) {
            throw new IllegalArgumentException("La escena no puede ser null");
        }

        URL archivoCss = EstilosAplicacion.class.getResource("/styles/soundsens.css");

        if (archivoCss == null) {
            throw new IllegalStateException("No se encontró el archivo de estilos");
        }

        scene.getStylesheets().add(archivoCss.toExternalForm());
    }
}