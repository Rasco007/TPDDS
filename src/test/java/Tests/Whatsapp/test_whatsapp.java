package Tests.Whatsapp;

import Domain.Entidades.Establecimiento;
import Domain.Notificaciones.Metodo_Notificacion;
import Domain.Notificaciones.Tipo_Sincronizacion.Cuando_Sucede;
import Domain.Notificaciones.Tipo_Sincronizacion.Metodo_Sincronizacion;
import Domain.Notificaciones.Whatsapp;
import Domain.Notificaciones.api_whatsapp.Whatsapp_Config;
import Domain.Personas.Comunidad;
import Domain.Personas.Perfil;
import Domain.Personas.Usuario;
import Domain.Servicio.Servicio;
import Domain.Servicio.Servicio_Base;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;



public class test_whatsapp {

    @Test
    public void mandarMensaje(){
        Twilio.init(Whatsapp_Config.ACCOUNT_SID, Whatsapp_Config.AUTH_TOKEN);


        Message message = Message.creator(
                        new PhoneNumber("whatsapp:+5491123270237"),
                        new PhoneNumber(Whatsapp_Config.numeroDeEnvio),
                        "Esta es una prueba de DDS")
                .create();

        System.out.println("Se envio el mensaje con id: " + message.getSid());
    }

    @Test
    public void flujoCompleto() throws MessagingException, IOException {
        Comunidad comunidad = new Comunidad();
        List<Usuario> lista = new ArrayList<Usuario>();
        Set<Comunidad> set = new HashSet<Comunidad>();

        Perfil perfil = new Perfil();

        Usuario usuario = new Usuario();
        usuario.setPerfil(perfil);
        usuario.getPerfil().setNombre("Colo");
        usuario.getPerfil().setTelefono("+5491157072015");
        usuario.getPerfil().setComunidades(set);
        lista.add(usuario);

        comunidad.setMiembros(lista);

        Metodo_Sincronizacion metodo_sincronizacion = new Cuando_Sucede();
        Metodo_Notificacion metodo_notificacion = new Whatsapp();

        usuario.getPerfil().setMetodo_sincronizacion(metodo_sincronizacion);
        usuario.getPerfil().setMetodo_notificacion(metodo_notificacion);


        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setNombre("Medrano");

        Servicio servicioOriginal = new Servicio_Base();
        servicioOriginal.setDescripcion("Escalera");

    }
}
