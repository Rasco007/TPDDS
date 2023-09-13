package Domain.Personas;

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

  public Incidente cargar_nuevo_incidente(Comunidad comunidad);

  public cerrar_incidente(Incidente incidente);

  public String getLogin() {
    return login;
  }

  public Perfil getPerfil() {
    return perfil;
  }

  public Rol getRoles() {
    return roles;
  }

  public String getPassword() {
    return password;
  }
}
