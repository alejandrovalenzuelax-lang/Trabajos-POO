package model;

public class Cancion {

    private String titulo;
    private String artista;
    private String rutaAlbum;
    private String rutaAudio;
    private String rutaVideo;
    private String rutaLyrics;
    private String rutaContexto;
    private int reproducciones;

    public Cancion(String titulo, String artista, String rutaAlbum, String rutaAudio,String rutaVideo, String rutaLyrics, String rutaContexto) {
        this.titulo = titulo;
        this.artista = artista;
        this.rutaAlbum = rutaAlbum;
        this.rutaAudio = rutaAudio;
        this.rutaVideo = rutaVideo;
        this.rutaLyrics = rutaLyrics;
        this.rutaContexto = rutaContexto;
        this.reproducciones = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getRutaAlbum() {
        return rutaAlbum;
    }

    public String getRutaAudio() {
        return rutaAudio;
    }

    public String getRutaVideo() {
        return rutaVideo;
    }

    public String getRutaLyrics() {
        return rutaLyrics;
    }

    public String getRutaContexto() {
        return rutaContexto;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public void incrementarReproducciones() {
        this.reproducciones++;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista;
    }
}
