import java.io.IOException;

public class Main {
    public static void main(String []args) throws IOException {

        CreadorDeArchivosCSV creadorCsv = new CreadorDeArchivosCSV();
        var archivoCreado = creadorCsv.crearArchivoCsv("archivo");

    }
}
