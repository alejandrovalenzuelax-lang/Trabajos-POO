package exception;

import java.io.IOException;

public class ArchivoCancionNoEncontradoException extends IOException{

    public ArchivoCancionNoEncontradoException(String message) {
        super(message);
    }
}
