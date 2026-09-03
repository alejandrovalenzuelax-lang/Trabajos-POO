public class VerificadorConexion {

    public boolean calcularDistancia (EquipoComputo dispositivo){
        if (dispositivo instanceof LaptopEstudiante){
            Double distancia = Math.sqrt(Math.pow(dispositivo.coordenadaX-0,2)+Math.pow(dispositivo.coordenadaY-0,2));
            if (distancia < 20){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
}
