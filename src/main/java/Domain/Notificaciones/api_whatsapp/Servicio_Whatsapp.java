package Domain.Notificaciones.api_whatsapp;

import Domain.Personas.Usuario;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Set;

public class Servicio_Whatsapp {
    private static Servicio_Whatsapp instancia = null;
    private static Set<Usuario> usuarios;
    private static String mensaje;

    public static Servicio_Whatsapp instancia(){
        if(instancia== null){
            instancia = new Servicio_Whatsapp();
        }
        return instancia;
    }

    public static void enviarMensaje(String telefono, String mensajeANotificar, String asunto){
        Twilio.init(Whastapp_Config.ACCOUNT_SID, Whastapp_Config.AUTH_TOKEN);

        mensaje = mensajeANotificar;

        Message message = Message.creator(
                        new PhoneNumber("whatsapp:" + telefono),
                        new PhoneNumber("whatsapp:+17605765980"),
                        "Asunto: " + asunto + "\n" + mensaje)
                .create();

        System.out.println(message.getSid());
    }
}