package Domain.Notificaciones.Tipos_Notificaciones;

import Domain.Incidente.Incidente;
import Domain.Personas.Usuario;
import Domain.personas.Miembro;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
public class Notificacion_Data implements NotificacionBuilder {

  Notificacion notificacion = new Notificacion("Apertura de incidente");

  @Override
  public Notificacion_Builder agregar_usuarios_a_notificar(Set<Usuario> usuarios_a_notificar) {
    notificacion.setUsuario_a_notificar(usuarios_a_notificar);
    return this;
  }

  @Override
  public Notificacion_Builder agregar_mensaje(Incidente incidente) {
    notificacion.setMensaje("El establecimiento " +  incidente.getEstablecimiento().getNombre()
            + " esta teniendo fallas en el servicio " + incidente.getServicio().getServicio().getNombre());
    return this;
  }


  @Override
  public Notificacion construir() {
    notificacion.setHorario_Notificacion(LocalDateTime.now().toLocalDate());
    return this.notificacion;
  }
}
