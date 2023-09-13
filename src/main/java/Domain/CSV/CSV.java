package Domain.CSV;

import lombok.Getter;
import lombok.Setter;
import Domain.Entidades.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class CSV {
    private List<Entidad> entidadesPrestadoras = new ArrayList<Entidad>();
    private List<Organismo_Control> organismosDeControl = new ArrayList<Organismo_Control>();

    public void cargarCSV(String archivoCSV) {
        try {
            String linea = "";
            BufferedReader buffer = new BufferedReader(new FileReader(archivoCSV));
            while ((linea = buffer.readLine()) != null) {
                String[] datoslinea = linea.split(",");
                String nombre = datoslinea[0].trim();
                String tipoEntidadPrestadora = datoslinea[1].trim();

                switch(tipoEntidadPrestadora){
                    case "ORGANISMO_DE_CONTROL":
                        Organismo_Control organismoDeControl = new Organismo_Control();
                        organismoDeControl.setNombre(nombre);
                        this.organismosDeControl.add(organismoDeControl);
                        break;
                    case "ENTIDAD_PRESTADORA":
                        Entidad entidadPrestadora = new Entidad(nombre);
                        this.entidadesPrestadoras.add(entidadPrestadora);
                        break;

                }
            }
            buffer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
