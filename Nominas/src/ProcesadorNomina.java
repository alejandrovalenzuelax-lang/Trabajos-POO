import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ProcesadorNomina {

    public Double procesarArchivo(String nombreArchivo){
        Double total = 0.0;
        int numeroLinea = 1;

        try{
            File archivo = new File(nombreArchivo);
            Scanner lector = new Scanner(archivo);

            while(lector.hasNextLine()) {
                String linea = lector.nextLine();

                try{
                    Double sueldo = Double.parseDouble(linea.trim());
                    total = total + sueldo;
                }catch (NumberFormatException e){
                    System.out.println("Linea " + numeroLinea + " omitida por formato invalido");
                }

                numeroLinea++;

            }

            lector.close();

        }catch (FileNotFoundException e){
            System.out.println("Error: No se encontro el archivo: " + nombreArchivo);

        }
        return total;

    }


}
