package service;

import model.Cancion;

import java.util.ArrayList;
import java.util.List;

public class BuscadorCanciones {

    private final List<Cancion> canciones;

    public BuscadorCanciones(List<Cancion> canciones) {

        if (canciones == null) {
            throw new IllegalArgumentException("La lista de canciones no puede ser null");
        }

        this.canciones = new ArrayList<>(canciones);
    }

    public ArrayList<Cancion> buscar(String texto) {

        if (texto == null) {
            throw new IllegalArgumentException("El texto de busqueda no puede ser null");
        }

        String busqueda = texto.trim().toLowerCase();

        if (busqueda.isBlank()){
            return new ArrayList<>(canciones);
        }
        ArrayList<Cancion> resultados = new ArrayList<>();

        for (Cancion cancion : canciones) {
            String titulo = cancion.getTitulo().toLowerCase();
            String artista = cancion.getArtista().toLowerCase();

            if (titulo.contains(busqueda) || artista.contains(busqueda)) {
                resultados.add(cancion);
            }

        }
        return resultados;
    }


}
