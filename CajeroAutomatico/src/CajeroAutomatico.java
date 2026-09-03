public class CajeroAutomatico {

    final private String pinCorrecto = "1234";

    public String getPinCorrecto() {
        return pinCorrecto;
    }

    public boolean validarNip(String nipRecibido) throws IntentoInvalidoException{
        if (pinCorrecto.equals(nipRecibido)){
            return true;
        }else {
           throw new IntentoInvalidoException("NIP incorrecto");
        }
    }

}
