/*package Domain.CSV;

import com.opencsv.*;
import java.io.FileReader;
import java.io.FileWriter;
import lombok.Getter;
import lombok.Setter;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter


public class CargaCSV {
    private List<Entidades> entidadesPrestadoras = new ArrayList<Entidades>();
    private List<OrganismoDeControl> organismosDeControl = new ArrayList<OrganismoDeControl>();

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
                        OrganismoDeControl organismoDeControl = new OrganismoDeControl(nombre);
                        this.organismosDeControl.add(organismoDeControl);
                        break;
                    case "ENTIDAD_PRESTADORA":
                        Entidades entidadPrestadora = new Entidades(nombre);
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
*/