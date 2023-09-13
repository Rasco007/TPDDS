package Domain.Entidades;

import Domain.Servicio.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Organismo_Control {
    private String nombre;
    private List<Entidad> entidades;
	  private List<Servicio> servicios;
}
