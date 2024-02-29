package Domain.CSV;

import Domain.Entidades.Entidad;
import Domain.Entidades.Organismo_Control;
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

public class CSV {
    private List<Entidad> entidades_prestadoras = new ArrayList<Entidad>();
    private List<Organismo_Control> organismos_control = new ArrayList<Organismo_Control>();

    public void cargarCSV(String archivoCSV) {
        try {
            String linea = "";
            BufferedReader buffer = new BufferedReader(new FileReader(archivoCSV));
            while ((linea = buffer.readLine()) != null) {
                String[] datoslinea = linea.split(";");
                String nombre = datoslinea[0].trim();
                String tipo_entidad_prestadora = datoslinea[1].trim();

                switch(tipo_entidad_prestadora){
                    case "ORGANISMO_DE_CONTROL":
                        Organismo_Control organismo_control = new Organismo_Control();
                        organismo_control.setNombre(nombre);
                        this.organismos_control.add(organismo_control);
                        break;
                    case "ENTIDAD_PRESTADORA":
                        Entidad entidad_prestadora = new Entidad();
                        entidad_prestadora.setNombre(nombre);
                        this.entidades_prestadoras.add(entidad_prestadora);
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
