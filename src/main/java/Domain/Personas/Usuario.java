package Domain.Personas;

import Domain.GeoRef.Entidades.Centroide;
import Domain.Servicio.Servicio;
import Domain.Incidente.Incidente;
import java.io.IOException;
import javax.mail.MessagingException;
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

  public void cargar_nuevo_incidente(Comunidad comunidad, Servicio servicio, String observaciones) throws MessagingException, IOException {
    Incidente incidente = new Incidente(servicio, observaciones, comunidad);
    incidente.crear_incidente(comunidad.getMiembros());
    comunidad.getListado_incidentes().add(incidente);
  }

  public void cerrar_incidente(Incidente incidente, Comunidad comunidad) throws MessagingException, IOException {
    incidente.cerrar_incidente(comunidad.getMiembros());
    comunidad.getListado_incidentes().remove(incidente);
  }
}
