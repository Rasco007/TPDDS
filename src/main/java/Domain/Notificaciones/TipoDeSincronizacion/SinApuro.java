package Domain.Notificacion.TipoDeSincronizacion;

import Domain.Notificacion.MetodoDeNotificacion;
import Domain.Notificacion.TiposDeNotificaciones.Notificacion;
import Domain.personas.Miembro;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

public class SinApuro implements MetodoDeSincronizacion {


    @Override
    public void notificar(Miembro miembro, Notificacion notificacion) {
        miembro.getPersona().getNotificacionesAcumuladas().add(notificacion);
    }

}
