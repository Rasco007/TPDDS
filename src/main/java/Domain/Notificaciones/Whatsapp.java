package Domain.Notificacion;

import Domain.Notificacion.apiWhatsapp.ServicioWhatsapp;
import Domain.personas.Miembro;
import Domain.personas.Persona;

public class Whatsapp implements MetodoDeNotificacion{
    public void notificar(Persona persona, String mensaje, String asunto){
        ServicioWhatsapp.enviarMensaje(persona.getTelefono(), mensaje, asunto);
    }
}
