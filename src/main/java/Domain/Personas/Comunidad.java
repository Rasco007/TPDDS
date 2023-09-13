package Domain.Personas;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comunidad {
  private String nombre;
  private List<Usuario> miembros;
  private List<Usuario> administradores;
  private List<Incidentes> listado_incidentes;
  private List<Usuario> miembros_observadores;
  private List<Usuario> miembros_afectados;
}
