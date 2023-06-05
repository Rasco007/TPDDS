package ar.edu.utn.frba.dds.CSV;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CSV{

  private FileReader archCSV = null;
  private CSVReader csvReader = null;

  private String pathCSV = "./Estado_Servicios.csv";

  public void crearCSV() {
    String [] header = {"Id","Lugar","Servicio","Estado","Usuario_designado","Comentarios"};

    CSVWriter writer = new CSVWriter(new FileWriter(pathCSV));

    writer.writeNext(header);

    writer.close();
  }

  public void cargarDatos(){

    CSVWriter writer = new CSVWriter(new FileWriter(pathCSV));

    writer.writeNext(header);

    writer.close();
  }

  public void leerArchivo(){
    archCSV = new FileReader(pathCSV);
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
