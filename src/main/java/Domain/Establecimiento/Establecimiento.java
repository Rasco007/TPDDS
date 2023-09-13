package Domain.Establecimiento;
import Domain.Entidades.Entidad;
import Domain.Servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Establecimiento {

    private String nombre;
    private Ubicacion ubicacion;
    private List<Servicio> servicios;
    private Entidad entidad;

}
