package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class LectorArchivosCancion {

    public String leerTexto(String ruta) throws IOException{
        if (ruta == null || ruta.isBlank()) {
            throw new IllegalArgumentException("La ruta no puede ser null");
        }

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo no existe: " + ruta);
        }

        if (!archivo.isFile()) {
            throw new IOException("La ruta no corresponde a un archivo: " + ruta);
        }

        if (!archivo.canRead()) {
            throw new IOException("No se tiene permisos para leer el archivo: " + ruta);
        }

        String contenido = Files.readString(
                archivo.toPath(),
                StandardCharsets.UTF_8
        );

        if (contenido.isBlank()) {
            throw new IOException("El archivo esta vacio: " + ruta);
        }

        return contenido;

    }

}
