package Domain.Servicios;

import Domain.Establecimiento.Establecimiento;
import Domain.Incidente.Incidente;
import Domain.Servicios.Estados.EstadoDelServicio;
import Domain.Usuario.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Servicio {

    private EstadoDelServicio estado;
    private String descripcion;
    private List<Usuario> usuarios;
    private Establecimiento establecimiento;
    private List<Incidente> incidentes;

}
