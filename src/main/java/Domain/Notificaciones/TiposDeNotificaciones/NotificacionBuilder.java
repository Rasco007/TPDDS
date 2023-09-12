package Domain.Notificacion.TiposDeNotificaciones;

import Domain.Incidente.Incidente;
import Domain.Notificacion.TiposDeNotificaciones.Notificacion;
import Domain.personas.Miembro;

import java.time.LocalDate;
import java.util.Set;

public interface NotificacionBuilder {

    NotificacionBuilder agregarMiembrosANotificar(Set<Miembro> miembrosANotificar);
    NotificacionBuilder agregarMensaje(Incidente incidente);

    Notificacion construir();
}
