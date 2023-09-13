package Domain.Notificacion.TipoDeSincronizacion;

import Domain.Notificacion.TiposDeNotificaciones.Notificacion;
import Domain.personas.Miembro;

public class SinApuro implements MetodoDeSincronizacion {


    @Override
    public void notificar(Miembro miembro, Notificacion notificacion) {
        miembro.getPersona().getNotificacionesAcumuladas().add(notificacion);
    }

}
