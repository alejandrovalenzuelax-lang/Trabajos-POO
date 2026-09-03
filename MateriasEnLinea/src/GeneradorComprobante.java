import java.util.concurrent.ThreadLocalRandom;

public class GeneradorComprobante {

    public  Integer generarComprobante(){
        Integer folio = ThreadLocalRandom.current().nextInt(1000,10000);
        return folio;
    }
}
