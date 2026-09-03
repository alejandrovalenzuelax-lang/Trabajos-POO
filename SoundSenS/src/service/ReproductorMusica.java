package service;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.Cancion;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class ReproductorMusica {

    private final List<Cancion> canciones;
    private int indiceActual;
    private MediaPlayer mediaPlayer;
    private double volumenActual;
    private boolean reproduccionContada;


    public ReproductorMusica(List<Cancion> canciones) {

        if (canciones == null){
            throw new IllegalArgumentException("Error al cargar lista de canciones");
        }
        if (canciones.isEmpty()){
            throw new IllegalArgumentException("Lista de canciones vacias");
        }

        this.canciones = canciones;
        this.indiceActual = 0;
        this.mediaPlayer = null;
        this.volumenActual = 1.0;
        this.reproduccionContada = false;
    }

    public void cargarCancion(int indice) {

        if (indice < 0 || indice >= canciones.size()) {
            throw new IllegalArgumentException("Índice de canción inválido");
        }

        Cancion cancionSeleccionada = canciones.get(indice);

        File archivoAudio = new File(cancionSeleccionada.getRutaAudio());

        if (!archivoAudio.isFile()) {
            throw new IllegalStateException("El archivo de audio no está disponible: " + archivoAudio.getPath());
        }

        String direccionAudio = archivoAudio.toURI().toString();

        Media media = new Media(direccionAudio);

        MediaPlayer nuevoMediaPlayer = new MediaPlayer(media);

        nuevoMediaPlayer.setVolume(volumenActual);

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }

        mediaPlayer = nuevoMediaPlayer;
        indiceActual = indice;
        reproduccionContada = false;
    }

    public void cargarCancion(Cancion cancion) {
        if (cancion == null){
            throw new IllegalArgumentException("La cancion seleccionada no puede ser null");
        }

        int indice = canciones.indexOf(cancion);

        if (indice == -1){
            throw new IllegalArgumentException("La cancion no pertenece al reproductor");
        }

        cargarCancion(indice);
    }

    public void reproducirCancion () {
        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay una cancion cargada");
        }

        if (!reproduccionContada){
            Cancion cancionActual = canciones.get(indiceActual);
            cancionActual.incrementarReproducciones();
            reproduccionContada = true;
        }

        mediaPlayer.play();

    }


    public void pausarCancion () {
        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay una cancion cargada");
        }

        mediaPlayer.pause();

    }

    public void siguienteCancion () {
        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay una cancion cargada");
        }

        int siguienteIndice = indiceActual + 1;

        if (siguienteIndice >= canciones.size()) {
            siguienteIndice = 0;
        }

        cargarCancion(siguienteIndice);
        reproducirCancion();

    }

    public void anteriorCancion (){

        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay una cancion cargada");
        }

        int anteriorIndice = indiceActual - 1;

        if (anteriorIndice < 0) {
            anteriorIndice = canciones.size() - 1;
        }

        cargarCancion(anteriorIndice);
        reproducirCancion();

    }

    public void adelantarCancion (double segundos) {

        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay una cancion cargada");
        }

        if (segundos <= 0) {
            throw new IllegalArgumentException("Los segundos deben ser mayores que cero");
        }

        Duration tiempoActual = mediaPlayer.getCurrentTime();
        Duration tiempoNuevo = tiempoActual.add(Duration.seconds(segundos));
        mediaPlayer.seek(tiempoNuevo);


    }

    public void atrasarCancion (double segundos) {

        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay una cancion cargada");
        }

        if (segundos <= 0) {
            throw new IllegalArgumentException("Los segundos deben ser mayores que cero");
        }

        Duration tiempoActual = mediaPlayer.getCurrentTime();

        Duration tiempoNuevo = tiempoActual.subtract(Duration.seconds(segundos));

        if (tiempoNuevo.lessThan(Duration.ZERO)) {
            tiempoNuevo = Duration.ZERO;
        }

        mediaPlayer.seek(tiempoNuevo);

    }

    public void detenerCancion () {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer = null;
        }
    }

    public void cambiarVolumen (double volumen) {
        if (volumen < 0 || volumen > 1) {
            throw new IllegalArgumentException("El volumen debe estar entre 0.0 y 1.0");
        }

        volumenActual = volumen;

        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volumenActual);
        }

    }

    public Cancion getCancionActual() {
        return canciones.get(indiceActual);
    }

    public boolean hayCancionCargada() {
        return mediaPlayer != null;
    }

    public List<Cancion> getCanciones() {
        return new ArrayList<>(canciones);
    }

    public List<Cancion> getCancionesMasEscuchadas() {
        List<Cancion> cancionesOrdenadas = new ArrayList<>(canciones);

        cancionesOrdenadas.sort((cancion1, cancion2) -> Integer.compare(cancion2.getReproducciones(), cancion1.getReproducciones()));
        return cancionesOrdenadas;
    }

}
