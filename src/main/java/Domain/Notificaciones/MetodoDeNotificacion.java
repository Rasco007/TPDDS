package Domain.Notificacion;

import Domain.personas.Miembro;
import Domain.personas.Persona;

import javax.mail.MessagingException;
import java.io.IOException;

public interface MetodoDeNotificacion {

    void notificar(Persona persona, String mensaje, String asunto) throws MessagingException, IOException;
}
