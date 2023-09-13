package Domain.Notificaciones;

import Domain.Notificaciones.api_gmail.Servicio_Gmail;
import Domain.Personas.Usuario;
import javax.mail.MessagingException;
import java.io.IOException;

public class Email implements Metodo_Notificacion{
    @Override
    public void notificar(Usuario usuario, String mensaje, String asunto) throws MessagingException, IOException {
        Servicio_Gmail.enviarMensaje(usuario.getPerfil().getCorreo(), mensaje, asunto);
    }
}
