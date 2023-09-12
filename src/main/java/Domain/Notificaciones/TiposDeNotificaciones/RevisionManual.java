package Domain.Notificacion.TiposDeNotificaciones;

import Domain.Incidente.Incidente;
import Domain.Notificacion.TiposDeNotificaciones.NotificacionData;
import Domain.personas.Miembro;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
public class RevisionManual implements NotificacionBuilder {
    Notificacion notificacion = new Notificacion("Revision manual de incidente");;


    @Override
    public NotificacionBuilder agregarMiembrosANotificar(Set<Miembro> miembrosANotificar) {
        notificacion.setMiembrosANotificar(miembrosANotificar);
        return this;
    }

    @Override
    public NotificacionBuilder agregarMensaje(Incidente incidente) {
        notificacion.setMensaje("Le pedimos por favor si se tomaria la molestia de revisar el servicio "
                + incidente.getServicio().getServicio().getNombre() +
                "del establecimiento " + incidente.getEstablecimiento().getNombre());
        return this;
    }



    @Override
    public Notificacion construir() {
        notificacion.setHorarioDeNotificacion(LocalDateTime.now().toLocalDate());
        return this.notificacion;
    }
  /*
    @Override
    public Notificacion armarNotificacion(Set<Miembro> miembrosANotificar, Incidente incidente) {
        super.setMiembrosANotificar(miembrosANotificar);
        super.setHorarioDeNotificacion(LocalDate.now());
        super.setMensaje("Le pedimos por favor si se tomaria la molestia de revisar el servicio: "
                + incidente.getServicio().getServicio().getNombre() +
                "del establecimiento: " + incidente.getEstablecimiento().getNombre());
        return this;
    }
    */

}
