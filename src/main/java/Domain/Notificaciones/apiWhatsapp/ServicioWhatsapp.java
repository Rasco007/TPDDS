package Domain.Notificaciones.apiWhatsapp;

import Domain.Incidente.Incidente;
import Domain.Entidades.Usuario;
import Domain.GeoRef.ServicioGeoref;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Set;

public class ServicioWhatsapp {
    private static ServicioWhatsapp instancia = null;
    private static Set<Usuario> usuarios;
    private static String mensaje;

    public static ServicioWhatsapp instancia(){
        if(instancia== null){
            instancia = new ServicioWhatsapp();
        }
        return instancia;
    }

    public static void enviarMensaje(String telefono, String mensajeANotificar, String asunto){
        Twilio.init(WppConfig.ACCOUNT_SID, WppConfig.AUTH_TOKEN);

        mensaje = mensajeANotificar;

        Message message = Message.creator(
                        new PhoneNumber("whatsapp:" + telefono),
                        new PhoneNumber("whatsapp:+17605765980"),
                        "Asunto: " + asunto + "\n" + mensaje)
                .create();

        System.out.println(message.getSid());
    }
}



