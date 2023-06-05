package ar.edu.utn.frba.dds.CSV;
import com.openCSV

public class CSV{

  FileReader archCSV = null;
  CSVReader csvReader = null;

  private String archCSV = "./Estado_Servicios.csv";

  public crearCSV() {
    String [] header = {"Id","Lugar","Servicio","Estado","Usuario_designado","Comentarios"};

    CSVWriter writer = new CSVWriter(new FileWriter(archCSV));

    writer.writeNext(header);

    writer.close();
  }

  public cargarDatos(){

    CSVWriter writer = new CSVWriter(new FileWriter(archCSV));

    writer.writeNext(header);

    writer.close();
  }

  public leerArchivo(){
    archCSV = new FileReader("./Estado_Servicios.csv");
    CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
    csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
    String[] fila = null;
    while((fila = csvReader.readNext()) != null) {
      System.out.println(fila[0]
          + " | " + fila[1]
          + " |  " + fila[2]);
    }
    archCSV.close();
    csvReader.close();
  }

}
