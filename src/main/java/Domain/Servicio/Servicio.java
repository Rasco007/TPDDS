package Domain.Servicio;

import Domain.Entidades.Establecimiento;
import Domain.Personas.Usuario;
import Domain.Servicio.Estados.Estado_Servicio;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Servicio {
  private Estado_Servicio estado_servicio;
  private String descripcion;
  private List<Usuario> usuarios_asociados;
  private Establecimiento establecimiento;
}
