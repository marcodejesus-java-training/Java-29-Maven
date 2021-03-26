import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String []args) throws IOException {
        String nombreDelArchivo = "archivo";
        CreadorDeArchivosCSV creadorCsv = new CreadorDeArchivosCSV();

        var archivoCreado = creadorCsv.crearArchivoCsv(nombreDelArchivo);

        if(archivoCreado){
            Reader lectorDeArchivo = new FileReader(nombreDelArchivo+".csv");

            Iterable<CSVRecord> registros = CSVFormat.DEFAULT
                    .withHeader(creadorCsv.ENCABEZADOS)
                    .withFirstRecordAsHeader()
                    .parse(lectorDeArchivo);

            for (var registro : registros) {
                System.out.print(registro.get("Nombre") + " " + registro.get("Apellido Paterno"));
                System.out.println();
            }
        }
    }
}
