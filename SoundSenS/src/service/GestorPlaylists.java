package service;

import model.Cancion;
import model.Playlist;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GestorPlaylists {


    private final Map<String, Playlist> playlists;
    private final List<Cancion> cancionesDisponibles;
    private final File carpetaPlaylists;

    public GestorPlaylists(List<Cancion> cancionesDisponibles) {

        if (cancionesDisponibles == null) {
            throw new IllegalArgumentException(
                    "La lista de canciones no puede ser null"
            );
        }

        this.cancionesDisponibles = new ArrayList<>(cancionesDisponibles);

        this.playlists = new LinkedHashMap<>();

        this.carpetaPlaylists = new File("data/playlists");
    }

    public Playlist crearPlaylist(String nombre) throws IOException {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la playlist no puede estar vacio");
        }

        String nombreLimpio = nombre.trim();

        if (nombreLimpio.contains("/") || nombreLimpio.contains("\\")){
            throw new IllegalArgumentException("El nombre contien caracteres no permitidos");
        }

        String clave = nombreLimpio.toLowerCase();

        if (playlists.containsKey(clave)) {
            throw new IllegalStateException("Ya existe un playlist con este nombre");
        }

        if (carpetaPlaylists.exists() && !carpetaPlaylists.isDirectory()) {
            throw new IOException("La ruta de playlist no es una carpeta");
        }

        if (!carpetaPlaylists.exists() && !carpetaPlaylists.mkdirs()){
            throw new IOException("No se pudo crear la carpeta de playlists");
        }

        File archivoPlaylist = new File(carpetaPlaylists, nombreLimpio + ".txt");

        boolean archivoCreado = archivoPlaylist.createNewFile();

        if (!archivoCreado) {
            throw new IllegalStateException("El archivo de la playlist ya existe");
        }

        Playlist playlist = new Playlist(nombreLimpio, archivoPlaylist.getPath());
        playlists.put(clave,playlist);

        return playlist;

    }

    public List<Playlist> getPlaylists() {
        return new ArrayList<>(playlists.values());
    }

    public void eliminarPlaylist(String nombre) throws IOException {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        String nombreLimpio = nombre.trim();

        if (nombreLimpio.contains("/") || nombreLimpio.contains("\\")){
            throw new IllegalArgumentException("El nombre contien caracteres no permitidos");
        }

        String clave = nombreLimpio.toLowerCase();

        Playlist playlist = playlists.get(clave);

        if (playlist == null){
            throw new IllegalStateException("El playlist no existe");
        }

        File archivoPlaylist = new File(playlist.getRutaArchivo());

        if (!archivoPlaylist.exists()) {
            throw new IOException("No se encontró el archivo de la playlist");}

        if (!archivoPlaylist.isFile()) {
            throw new IOException("La ruta de la playlist no corresponde a un archiv");
        }

        boolean archivoEliminado = archivoPlaylist.delete();

        if (!archivoEliminado) {
            throw new IOException("No se puedo eliminar el archivo de la playlist");
        }

        playlists.remove(clave);


    }

    public void agregarCancionAPlaylist(String nombrePlaylist, Cancion cancion) throws IOException {
        if (nombrePlaylist == null || nombrePlaylist.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if (cancion == null){
            throw new IllegalArgumentException("La cancion no puede ser null");
        }

        String clave = nombrePlaylist.trim().toLowerCase();

        Playlist playlist = playlists.get(clave);

        if (playlist == null){
            throw new IllegalStateException("El playlist no existe");
        }

        playlist.agregarCancion(cancion);

        String linea = cancion.getArtista() + " - " + cancion.getTitulo() + System.lineSeparator();

        try{
            Path ruta = Path.of(playlist.getRutaArchivo());

            Files.writeString(ruta, linea, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        } catch (IOException e){
            playlist.eliminarCancion(cancion);
            throw new IOException("No se pudo guardar la cancion en la playlist", e);
        }

    }

    private Cancion buscarCancionExacta(String artista, String titulo){
        for (Cancion cancion : cancionesDisponibles) {
            boolean mismoArtista = cancion.getArtista().equalsIgnoreCase(artista.trim());

            boolean mismoTitulo = cancion.getTitulo().equalsIgnoreCase(titulo.trim());

            if (mismoArtista && mismoTitulo){
                return cancion;
            }
        }

        return null;
    }

    public void cargarPlaylists() throws IOException {
        if (carpetaPlaylists.exists() && !carpetaPlaylists.isDirectory()) {
            throw new IOException("La ruta de la playlist no es una carpeta");
        }

        if (!carpetaPlaylists.exists()){
            if (!carpetaPlaylists.mkdirs()){
                throw new IOException("No se pudo crear la carpeta de playlists");
            }

            return;
        }

        File [] archivosPlaylist = carpetaPlaylists.listFiles( archivo -> archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt"));

        if  (archivosPlaylist == null){
            throw new IOException("No se pudieron leer los archvios de playlists");
        }

        playlists.clear();

        for (File archivoPlaylist : archivosPlaylist) {
            String nombreArchivo = archivoPlaylist.getName();

            String nombrePlaylist = nombreArchivo.substring(0, nombreArchivo.length() - 4);

            Playlist playlist = new Playlist(nombrePlaylist, archivoPlaylist.getPath());

            List<String> lineas = Files.readAllLines(archivoPlaylist.toPath(), StandardCharsets.UTF_8);

            for (String linea : lineas) {
                if (linea.isBlank()){
                    continue;
                }

                String[] partes = linea.split(" - ",2);

                if (partes.length != 2){
                    throw new IOException("Formato invalido en: " + archivoPlaylist.getName());
                }

                String artista = partes[0].trim();
                String titulo = partes[1].trim();

                Cancion cancion = buscarCancionExacta(artista, titulo);

                if (cancion == null){
                    throw new IOException("No se encontro la cancion: " + linea);
                }

                try{
                    playlist.agregarCancion(cancion);
                }catch (IllegalStateException e){
                    throw new IOException("Cancion duplicada en: " + archivoPlaylist.getName(), e);
                }

            }

            String clave = nombrePlaylist.trim().toLowerCase();

            if (playlists.containsKey(clave)){
                throw new IOException("Hay playlists duplicadas: " + nombrePlaylist);
            }

            playlists.put(clave, playlist);

        }

    }

    public void eliminarCancionDePlaylist(String nombrePlaylist, Cancion cancion) throws IOException{
        if (nombrePlaylist == null || nombrePlaylist.isBlank()){
            throw new IllegalArgumentException("El nombre de la playlist no puede estar vacio");
        }

        if (cancion == null){
            throw new IllegalArgumentException("El cancion no puede ser null");
        }

        String clave = nombrePlaylist.trim().toLowerCase();
        Playlist playlist = playlists.get(clave);

        if (playlist == null){
            throw new IllegalStateException("La playlist no existe");
        }

        List<Cancion> cancionesRestantes = playlist.getCanciones();
        boolean econtrada = cancionesRestantes.remove(cancion);

        if (!econtrada){
            throw new IllegalStateException("La cancion no pertenece a la playlist");
        }

        List<String> lineas = new ArrayList<>();

        for (Cancion cancionRestante : cancionesRestantes){

            String linea = cancionRestante.getArtista() + " - " + cancionRestante.getTitulo();

            lineas.add(linea);

        }

        try{
            Files.write(Path.of(playlist.getRutaArchivo()), lineas, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

            playlist.eliminarCancion(cancion);

        }catch (IOException e){
            throw new IOException("No se pudo eliminar la cancion", e);
        }

    }



}
