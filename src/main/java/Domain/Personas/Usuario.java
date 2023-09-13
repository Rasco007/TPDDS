package Domain.Personas;

import Domain.GeoRef.Entidades.Centroide;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Usuario {
  private String login;
  private String password;
  private Perfil perfil;
  private Rol roles;
  private Centroide ubicacion;

  public Incidente cargar_nuevo_incidente(Comunidad comunidad);

  public void cerrar_incidente(Incidente incidente);
}
