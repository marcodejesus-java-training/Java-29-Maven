import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marco De Jesus
 *
 */
public class CreadorDeArchivosCSV {
    public final Map<String, String> NombresDePersonas = new HashMap<String, String>(){
        {
            put("De Jesus", "Marco");
            put("Rodriguez", "Luis");
        }
    };
    public final String Encabezados[] = {"Apellido Paterno", "Nombre"};

    /**
     * Un metodo que nos ayuda a crear un Archivo en formato CSV,
     * con la ayuda de la libreria <a href="https://commons.apache.org/proper/commons-csv/">Apache Commons - CSV</a>.
     * <p>
     * El metodo regresa true si se ha creado con exito y false si no se ha creado.
     *
     * @param       nombreDelArchivo  el nombre del archivo con formato CSV.
     * @return      true si el archivo se guardo con Exito!
     * @see         org.apache.commons.csv.CSVPrinter
     * @see         Main
     * @exception IOException Cuando hay un problema con guardar el archivo.
     */
    public boolean crearArchivoCsv(String nombreDelArchivo) throws IOException{
        var escritorDeArchivo = new FileWriter(nombreDelArchivo + ".csv");
        var formatoConEncabezados = CSVFormat.DEFAULT.withHeader(Encabezados);

        var impresoraCsv = new CSVPrinter(escritorDeArchivo, formatoConEncabezados);

        try {
            NombresDePersonas.forEach((apellidoPaterno, nombre) -> {
                try {
                    impresoraCsv.printRecord(apellidoPaterno, nombre);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            return true;
        } finally{
            impresoraCsv.close();
        }
    }
}
