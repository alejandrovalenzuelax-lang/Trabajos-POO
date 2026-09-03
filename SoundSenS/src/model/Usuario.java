package model;

public class Usuario {

    private final String nombreUsuario;
    private final String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {

        if (nombreUsuario == null || nombreUsuario.isBlank()){
            throw new IllegalArgumentException("El nombre del usuario es obligatorio");
        }

        if (contrasena == null || contrasena.isBlank()){
            throw new IllegalArgumentException("La contrasena es obligatoria");
        }
        if (contrasena.length() < 8){
            throw new IllegalArgumentException("La contrasena debe tener 8 caracteres");
        }

        this.nombreUsuario = nombreUsuario.trim();
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean coincideContrasena (String contrasenaIngresada) {
        return contrasena.equals(contrasenaIngresada);
    }
}
