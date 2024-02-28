package Tests.Whatsapp;

import Domain.Entidades.Establecimiento;
import Domain.Incidente.Incidente;
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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* Para que funcione ir a
https://console.twilio.com/us1/develop/sms/try-it-out/whatsapp-learn?frameUrl=%2Fconsole%2Fsms%2Fwhatsapp%2Flearn%3Fx-target-region%3Dus1
    enviar join rabbit-planned a +1(415)5238886
 */

public class test_whatsapp {

    @Test
    public void mandarMensaje(){
        Twilio.init(Whatsapp_Config.ACCOUNT_SID, Whatsapp_Config.AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5491157072015"),
                new com.twilio.type.PhoneNumber(Whatsapp_Config.numeroDeEnvio),
                "Esta es una prueba de DDS")
            .create();

        System.out.println("Se envio el mensaje con id: " + message.getSid());
    }

    @Test
    public void flujoCompleto() throws MessagingException, IOException {
        // inicializacion de sets y lsitas
        Comunidad comunidad = new Comunidad();
        List<Usuario> lista = new ArrayList<Usuario>();
        Set<Comunidad> set = new HashSet<Comunidad>();
        set.add(comunidad);

        Perfil perfil = new Perfil();

        Usuario usuario = new Usuario();
        usuario.setPerfil(perfil);
        usuario.getPerfil().setNombre("Colo");
        usuario.getPerfil().setTelefono("+5491157072015");
        usuario.getPerfil().setComunidades(set);
        lista.add(usuario);

        comunidad.setMiembros( lista);

        // inicializacion del metodo de sincronizacion y notificacion
        Metodo_Sincronizacion metodo_sincronizacion = new Cuando_Sucede();
        Metodo_Notificacion metodo_notificacion = new Whatsapp();

        // inicializacion de perfiles y usuarios
        Perfil facundo_p = new Perfil();
        facundo_p.setNombre("Facundo");
        facundo_p.setTelefono("+5491157072015");
        facundo_p.setComunidades(set);
        facundo_p.setMetodo_sincronizacion(metodo_sincronizacion);
        facundo_p.setMetodo_notificacion(metodo_notificacion);
        Usuario facundo = new Usuario();
        facundo.setPerfil(facundo_p);

        Perfil brian_p = new Perfil();
        brian_p.setNombre("Brian");
        brian_p.setTelefono("+5491161900597");
        brian_p.setComunidades(set);
        brian_p.setMetodo_sincronizacion(metodo_sincronizacion);
        brian_p.setMetodo_notificacion(metodo_notificacion);
        Usuario brian = new Usuario();
        brian.setPerfil(brian_p);

        Perfil santino_p = new Perfil();
        santino_p.setNombre("Santino");
        santino_p.setTelefono("+5491138256413");
        santino_p.setComunidades(set);
        santino_p.setMetodo_sincronizacion(metodo_sincronizacion);
        santino_p.setMetodo_notificacion(metodo_notificacion);
        Usuario santino = new Usuario();
        santino.setPerfil(santino_p);

        Perfil nico_p = new Perfil();
        nico_p.setNombre("Nico");
        nico_p.setTelefono("+5491159884875");
        nico_p.setComunidades(set);
        nico_p.setMetodo_sincronizacion(metodo_sincronizacion);
        nico_p.setMetodo_notificacion(metodo_notificacion);
        Usuario nico = new Usuario();
        nico.setPerfil(nico_p);

        Perfil max_p = new Perfil();
        max_p.setNombre("Max");
        max_p.setTelefono("+5491156185768");
        max_p.setComunidades(set);
        max_p.setMetodo_sincronizacion(metodo_sincronizacion);
        max_p.setMetodo_notificacion(metodo_notificacion);
        Usuario max = new Usuario();
        max.setPerfil(max_p);

        // se agregan los usuarios a la lista de usuarios
        lista.add(facundo);
        lista.add(brian);
        lista.add(santino);
        lista.add(nico);
        lista.add(max);

        // se agrega la lista de usuarios a la comunidad
        comunidad.setMiembros(lista);

        // se inicializa la lista de incidentes y se la agrega a la comunidad
        comunidad.setListado_incidentes(new ArrayList<Incidente>());

        // se crea el establecimiento y el servicio de dicho establecimiento
        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setNombre("Medrano");
        Servicio servicio_original = new Servicio_Base();
        servicio_original.setDescripcion("Escalera");

        // se carga el incidente y luego se lo cierra
        facundo.cargar_nuevo_incidente(comunidad,servicio_original, "");
        facundo.cerrar_incidente(comunidad.getListado_incidentes().iterator().next(), comunidad);
    }
}
