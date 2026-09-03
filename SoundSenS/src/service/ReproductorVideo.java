package service;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaException;
import java.io.File;



public class ReproductorVideo {

    private MediaPlayer mediaPlayer;

    public ReproductorVideo() {
        this.mediaPlayer = null;
    }

    public void cargarVideo (String rutaVideo) {

        if (rutaVideo == null || rutaVideo.isBlank()) {
            throw new IllegalArgumentException("La ruta del video no puede estar vacia");
        }

        File archivoVideo = new File(rutaVideo);

        if (!archivoVideo.isFile()) {
            throw new IllegalStateException("El video no esta disponible: " + rutaVideo);
        }

        try{
            String direccionVideo = archivoVideo.toURI().toString();

            Media media = new Media(direccionVideo);

             MediaPlayer nuevoMediaPlayer = new MediaPlayer(media);

             if (mediaPlayer != null) {
                 mediaPlayer.stop();
                 mediaPlayer.dispose();
             }

             mediaPlayer = nuevoMediaPlayer;

        }catch (MediaException e){
            throw new IllegalStateException("No se pudo cargar el video",e);
        }

    }

    public void reproducir (){
        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay un video cargado");
        }
        mediaPlayer.play();
    }

    public void pausar() {
        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay un video cargado");
        }
        mediaPlayer.pause();
    }

    public void detener (){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer = null;
        }
    }

    public MediaPlayer getMediaPlayer() {

        if (mediaPlayer == null) {
            throw new IllegalStateException("No hay un video cargado");
        }
        return mediaPlayer;
    }

}
