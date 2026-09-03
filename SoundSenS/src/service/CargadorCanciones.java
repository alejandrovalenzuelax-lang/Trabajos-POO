package service;

import exception.ArchivoCancionNoEncontradoException;
import model.Cancion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class CargadorCanciones {


    private void validarArchivo (File archivo , String descripcion) throws ArchivoCancionNoEncontradoException {

        if (!archivo.exists()) {
            throw new ArchivoCancionNoEncontradoException(
                    "No se encontró " + descripcion + ": " + archivo.getPath()
            );
        }

        if (!archivo.isFile()) {
            throw new ArchivoCancionNoEncontradoException("Error: "+archivo+" No es un archivo");
        }

    }


    public ArrayList<Cancion> cargarCanciones () throws IOException {

        String rutaBase = "data/canciones/";
        File carpetaBase = new File(rutaBase);

        if (!carpetaBase.exists()){
            throw new IOException("La carpeta no existe");
        }

        if (!carpetaBase.isDirectory()){
            throw new IOException("La ruta no es carpeta ");
        }

        File[] carpetasCanciones = carpetaBase.listFiles();

        if (carpetasCanciones == null){
            throw new IOException("No se pudo leer la carpeta: " + carpetaBase.getPath());
        }

        if (carpetasCanciones.length == 0){
            throw new IOException("No se pudo leer la carpeta");
        }

        ArrayList<Cancion> canciones = new ArrayList<>();

        for (File carpetaCancion : carpetasCanciones){
            if (!carpetaCancion.isDirectory()){
                continue;
            }

            String nombreCancion = carpetaCancion.getName();
            String [] partes = nombreCancion.split(" - ",2);
            if (partes.length != 2){

                continue;
            }

            String titulo = partes[1].trim();
            String artista = partes [0].trim();

            try{
                String rutaCarpeta =  carpetaCancion.getPath();
                File archivoAlbum = new File(carpetaCancion, "album.jpg");
                validarArchivo(archivoAlbum,"foto album");
                File archivoAudio = new File(carpetaCancion, "song.mp3");
                validarArchivo(archivoAudio,"cancion");
                File archivoVideo = new File(carpetaCancion, "video.mp4");
                validarArchivo(archivoVideo,"video");
                File archivoLyrics = new File(carpetaCancion, "lyrics.txt");
                validarArchivo(archivoLyrics,"letra");
                File archivoContexto = new File(carpetaCancion, "contexto.txt");
                validarArchivo(archivoContexto,"contexto");


                Cancion cancion = new Cancion(titulo,artista,archivoAlbum.getPath(),archivoAudio.getPath(),archivoVideo.getPath(),archivoLyrics.getPath(),archivoContexto.getPath());
                canciones.add(cancion);

            }catch (ArchivoCancionNoEncontradoException e){
                System.out.println(e.getMessage());
            }


        }

        if (canciones.isEmpty()){
            throw new IOException("No se pudo cargar ninguna cancion valida");
        }

        return canciones;
    }

}



