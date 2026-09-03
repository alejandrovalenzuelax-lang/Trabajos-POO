package controller;

import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Cancion;
import model.Playlist;
import model.Usuario;
import service.*;
import view.*;
import exception.CredencialesInvalidasException;
import exception.UsuarioYaExisteException;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class ControladorAplicacion {

    private final Stage stage;
    private final GestorUsuarios gestorUsuarios ;
    private final ReproductorMusica reproductor;
    private Usuario usuarioActual;
    private final BuscadorCanciones buscadorCanciones;
    private final LectorArchivosCancion lectorArchivosCancion;
    private final ReproductorVideo reproductorVideo;
    private final GestorPlaylists gestorPlaylists;

    public ControladorAplicacion(Stage stage, GestorUsuarios gestorUsuarios, ReproductorMusica reproductor) throws IOException {
        this.stage = stage;
        this.gestorUsuarios = gestorUsuarios;
        this.reproductor = reproductor;
        this.usuarioActual = null;
        this.buscadorCanciones = new BuscadorCanciones(reproductor.getCanciones());
        this.lectorArchivosCancion = new LectorArchivosCancion();
        this.reproductorVideo = new ReproductorVideo();
        this.gestorPlaylists = new GestorPlaylists(reproductor.getCanciones());
        this.gestorPlaylists.cargarPlaylists();
    }

    public void iniciarSesion(String nombreUsuario, String contrasena) throws CredencialesInvalidasException {
        usuarioActual = gestorUsuarios.iniciarSesion(nombreUsuario,contrasena);
        mostrarInicio();
    }

    public Usuario getUsuarioActual() {
        if (usuarioActual == null) {
            throw new IllegalStateException("No hay un usuario con sesion iniciada");
        }
        return usuarioActual;
    }

    public Cancion obtenerCancionActual() {
        return reproductor.getCancionActual();
    }

    public void registrarUsuario(String nombreUsuario, String contrasena) throws UsuarioYaExisteException, IOException {
        gestorUsuarios.registrarUsuario(nombreUsuario,contrasena);
    }

    public ArrayList<Cancion> buscarCanciones(String texto) {
        return buscadorCanciones.buscar(texto);
    }

    public void reproducirCancion(Cancion cancion) {
        if (cancion == null) {
            throw new IllegalArgumentException("Debes seleccionar una cancion");
        }

        reproductor.cargarCancion(cancion);
        reproductor.reproducirCancion();
        mostrarReproductor();

    }

    public MediaPlayer prepararVideoActual(){
        if (reproductor.hayCancionCargada()){
            reproductor.pausarCancion();
        }

        Cancion cancionActual = reproductor.getCancionActual();

        reproductorVideo.cargarVideo(cancionActual.getRutaVideo());
        return reproductorVideo.getMediaPlayer();
    }

    public void reproducirVideo() {
        reproductorVideo.reproducir();
    }

    public void pausarVideo() {
        reproductorVideo.pausar();
    }

    public void cerrarVideo(){
        reproductorVideo.detener();
        mostrarReproductor();
    }

    public String obtenerLyricsCancionActual() throws IOException{
        Cancion cancionActual = reproductor.getCancionActual();

        return lectorArchivosCancion.leerTexto(cancionActual.getRutaLyrics());

    }

    public String obtenerContextoCancionActual() throws IOException{
        Cancion cancionActual = reproductor.getCancionActual();

        return lectorArchivosCancion.leerTexto(cancionActual.getRutaContexto());
    }

    public List<Playlist> obtenerPlaylists() {
        return gestorPlaylists.getPlaylists();
    }

    public Playlist crearPlaylist(String nombre) throws IOException {
        return gestorPlaylists.crearPlaylist(nombre);
    }

    public void eliminarPlaylist(String nombre) throws IOException {
        gestorPlaylists.eliminarPlaylist(nombre);
    }

    public List<Cancion> obtenerCancionesPlaylist(Playlist playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("Debes seleccionar una playlist");
        }
        return playlist.getCanciones();
    }

    public void agregarCancionActualAPlaylist(Playlist playlist) throws IOException {
        if (playlist == null) {
            throw new IllegalArgumentException("Debes seleccionar una playlist");
        }

        if (!reproductor.hayCancionCargada()) {
            throw new IllegalStateException("No hay una cancion cargado");
        }

        Cancion cancionActual = reproductor.getCancionActual();

        gestorPlaylists.agregarCancionAPlaylist(playlist.getNombre(), cancionActual);

    }

    public void eliminarCancionDePlaylist(Playlist playlist, Cancion cancion) throws IOException {

        if (playlist == null) {
            throw new IllegalArgumentException("Debes seleccionar una playlist");
        }

        if (cancion == null) {
            throw new IllegalArgumentException("Debes seleccionar una cancion");
        }

        gestorPlaylists.eliminarCancionDePlaylist(playlist.getNombre(), cancion);

    }

    public List<Cancion> obtenerCancionesMasEscuchadas() {
        return reproductor.getCancionesMasEscuchadas();
    }

    public void mostrarPlaylists(){
        PlaylistView playlistView = new PlaylistView(stage, this);
        playlistView.mostrar();
    }

    public void mostrarEstadisticas(){
        EstadisticaView estadisticaView = new EstadisticaView(stage, this);
        estadisticaView.mostrar();
    }

    public void mostrarLyrics(){
        LyricsView view = new LyricsView(stage,this);
        view.mostrar();
    }

    public void mostrarContexto(){
        ContextoView view = new ContextoView(stage,this);
        view.mostrar();
    }

    public void mostrarLogin(){
        LoginView loginView = new LoginView(stage, this);
        loginView.mostrar();
    }

    public void mostrarRegistro(){
        RegistroView registroView = new RegistroView(stage, this);
        registroView.mostrar();
    }

    public void mostrarInicio(){
        InicioView inicioView = new InicioView(stage, this);
        inicioView.mostrar();
    }

    public void mostrarReproductor(){
        ReproductorView reproductorView = new ReproductorView(stage,reproductor,this);
        reproductorView.mostrar();
    }

    public void mostrarBusqueda(){
        BusquedaView busquedaView = new BusquedaView(stage,this);
        busquedaView.mostrar();
    }

    public void mostrarPerfil(){
        PerfilView perfilView = new PerfilView(stage,this);
        perfilView.mostrar();
    }

    public void mostrarVideo(){
        VideoView videoView = new VideoView(stage,this);
        videoView.mostrar();
    }

    public void cerrarSesion(){
        reproductor.detenerCancion();
        usuarioActual = null;
        mostrarLogin();
    }

}
