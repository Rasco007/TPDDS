package Domain.Notificacion.TiposDeNotificaciones;

import Domain.Incidente.Incidente;
import Domain.personas.Miembro;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
public class NotificacionDataCierre implements NotificacionBuilder {
    Notificacion notificacion = new Notificacion("Cierre de incidente");;
    @Override
    public NotificacionBuilder agregarMiembrosANotificar(Set<Miembro> miembrosANotificar) {
        notificacion.setMiembrosANotificar(miembrosANotificar);
        return this;
    }

    @Override
    public NotificacionBuilder agregarMensaje(Incidente incidente) {
        notificacion.setMensaje("El establecimiento " +  incidente.getEstablecimiento().getNombre()
                + " solucionó las fallas en el servicio " + incidente.getServicio().getServicio().getNombre());
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
        super.setMensaje("El establecimiento: " + incidente.getEstablecimiento().getNombre()
                + " solucionó las fallas en el servicio: " + incidente.getServicio().getServicio().getNombre());
        return this;
    }
*/
}
