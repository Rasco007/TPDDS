package Domain.Notificaciones.Tipo_Sincronizacion;

import Domain.Notificaciones.Tipos_Notificaciones.Notificacion;
import Domain.Personas.Usuario;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Metodo_Sincronizacion {

    void notificar(Usuario usuario, Notificacion notificacion) throws MessagingException, IOException;
}
