package Domain.Notificaciones;

import Domain.Personas.Usuario;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Metodo_Notificacion {

    void notificar(Usuario usuario, String mensaje, String asunto) throws MessagingException, IOException;
}
