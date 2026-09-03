package view;

import controller.ControladorAplicacion;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import model.Cancion;

import java.util.List;

public class EstadisticaView {

    private final Stage stage;
    private final ControladorAplicacion controlador;

    public EstadisticaView(Stage stage, ControladorAplicacion controlador) {
        this.stage = stage;
        this.controlador = controlador;
    }

    public void mostrar() {

        Label titulo = new Label("Canciones mas escuchadas");

        List<Cancion> ranking = controlador.obtenerCancionesMasEscuchadas();
        ObservableList<String> elementos = FXCollections.observableArrayList();

        for (int posicion = 0; posicion < ranking.size(); posicion++) {

            Cancion cancion = ranking.get(posicion);

            String texto = (posicion + 1) + ". " + cancion.getTitulo() + " - " + cancion.getArtista() + " | " + cancion.getReproducciones() + " reproducciones";

            elementos.add(texto);

        }

        ListView<String> listaRanking = new ListView<>(elementos);
        listaRanking.setPrefSize(600,400);

        Button botonVolver = new Button("Volver");

        botonVolver.setOnAction(e -> {
            controlador.mostrarInicio();
        });

        VBox contenedor = new VBox(15);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(25));

        contenedor.getChildren().addAll(
                titulo,
                listaRanking,
                botonVolver
        );

        Scene scene = new Scene(contenedor, 1000, 600);
        EstilosAplicacion.aplicar(scene);
        stage.setScene(scene);
        stage.setTitle("SoundSenS - Estadisticas");
        stage.show();

    }

}
