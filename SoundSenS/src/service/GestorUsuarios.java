package service;


import exception.CredencialesInvalidasException;
import exception.UsuarioYaExisteException;
import model.Usuario;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorUsuarios {

    private final Map<String, Usuario> usuarios;
    private final File carpetaUsuarios;
    private final File archivoUsuarios;

    public GestorUsuarios() throws IOException {
        this.usuarios = new HashMap<>();
        this.carpetaUsuarios = new File("data/usuarios");
        this.archivoUsuarios = new File(carpetaUsuarios,"usuarios.txt");
        prepararArchivoUsuarios();
        cargarUsuarios();
    }

    public void registrarUsuario (String nombreUsuario, String contrasena) throws UsuarioYaExisteException, IOException {
        if (nombreUsuario == null || nombreUsuario.isBlank() || contrasena == null || contrasena.isBlank()) {
            throw new IllegalArgumentException("Usuario o Contraseña incorrecto");
        }
        String claveUsuario = nombreUsuario.trim().toLowerCase();

        if (claveUsuario.contains("|") || contrasena.contains("|")) {
            throw new IllegalArgumentException("El usuario y la contraseña no pueden contener |");
        }

        if (usuarios.containsKey(claveUsuario)) {
            throw new UsuarioYaExisteException("Este nombre de usuario ya existe" + nombreUsuario);
        }
        Usuario usuario = new Usuario(claveUsuario, contrasena);
        usuarios.put(claveUsuario, usuario);

        String linea = claveUsuario + "|" + contrasena + System.lineSeparator();

        try{
            Files.writeString(archivoUsuarios.toPath(), linea, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }catch (IOException e){
            usuarios.remove(claveUsuario);
            throw new IOException("No se pudo guardar el usuario " + e);
        }

    }

    public Usuario iniciarSesion(String nombreUsuario, String contrasena) throws CredencialesInvalidasException {

        if (nombreUsuario == null || nombreUsuario.isBlank() || contrasena == null || contrasena.isBlank()) {
            throw new CredencialesInvalidasException("Usuario o Contraseña incorrecto");
        }

        String claveUsuario = nombreUsuario.trim().toLowerCase();

        if (usuarios.containsKey(claveUsuario)) {
            Usuario usuario = usuarios.get(claveUsuario);
            if (usuario.coincideContrasena(contrasena)){
                return usuario;
            }
            throw new CredencialesInvalidasException("Usuario o Contraseña incorrecta");
        }
        throw new CredencialesInvalidasException("Usuario o Contraseña incorrecta");
    }

    private void prepararArchivoUsuarios() throws IOException {

        if (carpetaUsuarios.exists() && !carpetaUsuarios.isDirectory()){
            throw new IOException("La ruta de usuarios no es una carpeta");
        }

        if (!carpetaUsuarios.exists() && !carpetaUsuarios.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta de usuarios");
        }

        if (archivoUsuarios.exists() && !archivoUsuarios.isFile()) {
            throw new IOException("La ruta de usuarios no es una archivo");
        }

        if (!archivoUsuarios.exists() && !archivoUsuarios.createNewFile()) {
            throw new IOException("No se pudo crear el archivo de usuarios");
        }

        if (!archivoUsuarios.canRead() || !archivoUsuarios.canWrite()) {
            throw new IOException("No se puede leer o escribir el archivo de usuarios");
        }

    }

    private void cargarUsuarios() throws IOException {

        List<String> lineas = Files.readAllLines(archivoUsuarios.toPath(), StandardCharsets.UTF_8);

        usuarios.clear();

        for (String linea : lineas) {

            if (linea.isBlank()){
                continue;
            }

            String[] partes = linea.split("\\|",2);

            if (partes.length != 2){
                throw new IOException("Formato de usuarios invalido: " + linea);
            }

            String nombreUsuario = partes[0].trim().toLowerCase();
            String contrasena = partes[1];

            if (nombreUsuario.isBlank() || contrasena.isBlank()) {
                throw new IOException("Hay un usuario con datos vacios");
            }

            if (usuarios.containsKey(nombreUsuario)) {
                throw new IOException("Usuarios duplicado en el archivo: " +  nombreUsuario);
            }

            Usuario usuario = new Usuario(nombreUsuario, contrasena);
            usuarios.put(nombreUsuario, usuario);

        }

    }

}
