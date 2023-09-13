package Domain.Personas;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rol {
  private String nombre;
  private List<Permiso> permisos;

  public boolean tenes_permiso(Permiso permiso){
    return permisos.contains(permiso);
  }
}
