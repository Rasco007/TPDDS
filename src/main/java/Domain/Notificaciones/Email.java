package Domain.Notificacion;

import Domain.Notificacion.apiGmail.ServicioGmail;
import Domain.Notificacion.apiWhatsapp.ServicioWhatsapp;
import Domain.personas.Miembro;
import Domain.personas.Persona;

import javax.mail.MessagingException;
import java.io.IOException;

public class Email implements MetodoDeNotificacion{
    @Override
    public void notificar(Persona persona, String mensaje, String asunto) throws MessagingException, IOException {
        ServicioGmail.enviarMensaje(persona.getMail(), mensaje, asunto);
    }
}
