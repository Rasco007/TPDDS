package Domain.Notificacion.TipoDeSincronizacion;

import Domain.Notificacion.TiposDeNotificaciones.Notificacion;
import Domain.personas.Miembro;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Metodo_Sincronizacion {

    public void notificar(Miembro miembro, Notificacion notificacion) throws MessagingException, IOException;
}
