public class ProcesoInscripcion {
    GeneradorComprobante comprobante;
    VerificadorHistorial historial;

    public ProcesoInscripcion(GeneradorComprobante comprobante, VerificadorHistorial historial) {
        this.comprobante = comprobante;
        this.historial = historial;
    }

    public  boolean procesarInscripcion (Alumno alumno){
        if (historial.verificar(alumno)){
            Integer folio = this.comprobante.generarComprobante();
            return true;
        }
        return false;
    }

}
