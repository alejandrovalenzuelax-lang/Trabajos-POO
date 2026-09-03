package model;

import java.util.List;
import java.util.ArrayList;


public class Playlist {


    private final String nombre;
    private final String rutaArchivo;
    private final List<Cancion> canciones;


    public Playlist(String nombre, String rutaArchivo) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre de la playlist no puede estar vacío"
            );
        }

        if (rutaArchivo == null || rutaArchivo.isBlank()) {
            throw new IllegalArgumentException(
                    "La ruta de la playlist no puede estar vacía"
            );
        }

        this.nombre = nombre.trim();
        this.rutaArchivo = rutaArchivo;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public List<Cancion> getCanciones() {
        return new ArrayList<>(canciones);
    }


    public void agregarCancion(Cancion cancion) {
        if (cancion == null) {
            throw new IllegalArgumentException("La cancion no puede ser null");
        }

        if (canciones.contains(cancion)) {
            throw new IllegalStateException("La cancion ya esta en la playlist");
        }

        canciones.add(cancion);

    }

    public void eliminarCancion(Cancion cancion) {

        if (cancion == null) {
            throw new IllegalArgumentException("La cancion no puede ser null");
        }

        boolean eliminada = canciones.remove(cancion);

        if (!eliminada) {
            throw new IllegalStateException("La cancion no pertenece a la playlist");
        }


    }

    @Override
    public String toString() {
        return nombre;
    }
}
