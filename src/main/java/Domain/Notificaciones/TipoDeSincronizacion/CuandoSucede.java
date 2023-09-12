package Domain.Notificacion.TipoDeSincronizacion;

import Domain.Notificaciones.TiposDeNotificaciones.Notificacion;
import Domain.Entidades.Miembro;

import javax.mail.MessagingException;
import java.io.IOException;

public class CuandoSucede implements MetodoDeSincronizacion{
    @Override
    public void notificar(Miembro miembro, Notificacion notificacion) throws MessagingException, IOException {
        miembro.getPersona().getMetodoDeNotificacion().notificar(miembro.getPersona(), notificacion.getMensaje(), notificacion.getAsunto());
    }
}
