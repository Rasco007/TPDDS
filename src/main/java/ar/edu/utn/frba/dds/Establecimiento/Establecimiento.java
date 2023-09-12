package ar.edu.utn.frba.dds.Establecimiento;
import ar.edu.utn.frba.dds.Entidades.Entidad;
import ar.edu.utn.frba.dds.Servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
public class Establecimiento {

    private String nombre;
    private Ubicacion ubicacion;
    private List<Servicio> servicios;
    private Entidad entidad;

}
