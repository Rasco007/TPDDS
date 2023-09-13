package Domain.Servicio;

import Domain.Entidades.Establecimiento;
import Domain.Personas.Usuario;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servicio {
  private Estado_Servicio estado_servicio;
  private String descripcion;
  private List<Usuario> usuarios_asociados;
  private Establecimiento establecimiento;
}
