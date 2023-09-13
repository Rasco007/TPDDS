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
    private List<entidad> entidadesPrestadoras = new ArrayList<entidad>();
    private List<organismoControl> organismosDeControl = new ArrayList<organismoControl>();

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
                        organismoControl organismoDeControl = new organismoControl(nombre);
                        this.organismosDeControl.add(organismoDeControl);
                        break;
                    case "ENTIDAD_PRESTADORA":
                        entidad entidadPrestadora = new entidad(nombre);
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
