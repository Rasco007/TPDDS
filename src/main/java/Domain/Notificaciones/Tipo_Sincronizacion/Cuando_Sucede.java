package Domain.Notificaciones.Tipo_Sincronizacion;

import Domain.Notificaciones.Tipos_Notificaciones.Notificacion;

import Domain.Personas.Usuario;
import javax.mail.MessagingException;
import java.io.IOException;

public class Cuando_Sucede implements Metodo_Sincronizacion {
    @Override
    public void notificar(Usuario usuario, Notificacion notificacion) throws MessagingException, IOException {
        usuario.getPerfil().getMetodo_notificacion().notificar(usuario, notificacion.getMensaje(), notificacion.getAsunto());
    }
}
