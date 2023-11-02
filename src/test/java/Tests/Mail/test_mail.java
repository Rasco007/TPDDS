package Tests.Mail;

import Domain.Entidades.Establecimiento;
import Domain.Incidente.Incidente;
import Domain.Notificaciones.Email;
import Domain.Notificaciones.Metodo_Notificacion;
import Domain.Notificaciones.Tipo_Sincronizacion.Cuando_Sucede;
import Domain.Notificaciones.Tipo_Sincronizacion.Metodo_Sincronizacion;
import Domain.Notificaciones.api_gmail.Mail_Config;
import Domain.Notificaciones.api_gmail.Servicio_Gmail;
import Domain.Personas.Comunidad;
import Domain.Personas.Perfil;
import Domain.Personas.Usuario;
import Domain.Servicio.Servicio;
import Domain.Servicio.Servicio_Base;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;
import javax.mail.MessagingException;

class test_mail {

    @Test
    public void mandaMail(){
        try {
            Servicio_Gmail m = new Servicio_Gmail(Mail_Config.urlApi);


            m.enviarEmail("Test", "Hola mundo", "fdalsasso@frba.utn.edu.ar");

            System.out.println("Se ha enviado!!");
        } catch (InvalidParameterException | IOException | MessagingException ex) {
            System.out.println(ex.getMessage());
        }

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
        usuario.getPerfil().setNombre("Facundo");
        usuario.getPerfil().setCorreo("fndalsasso@gmail.com");
        usuario.getPerfil().setComunidades(set);
        lista.add(usuario);

        comunidad.setMiembros((Set<Usuario>) lista);


        Metodo_Sincronizacion metodo_sincronizacion = new Cuando_Sucede();
        Metodo_Notificacion metodo_notificacion = new Email();

        // inicializacion de perfiles y usuarios
        Perfil facundo_p = new Perfil();
        facundo_p.setNombre("Facundo");
        facundo_p.setCorreo("fdalsasso@frba.utn.edu.ar");
        facundo_p.setComunidades(set);
        facundo_p.setMetodo_sincronizacion(metodo_sincronizacion);
        facundo_p.setMetodo_notificacion(metodo_notificacion);
        Usuario facundo = new Usuario();
        facundo.setPerfil(facundo_p);

        Perfil brian_p = new Perfil();
        brian_p.setNombre("Brian");
        brian_p.setCorreo("bcolman@frba.utn.edu.ar");
        brian_p.setComunidades(set);
        brian_p.setMetodo_sincronizacion(metodo_sincronizacion);
        brian_p.setMetodo_notificacion(metodo_notificacion);
        Usuario brian = new Usuario();
        brian.setPerfil(brian_p);

        Perfil santino_p = new Perfil();
        santino_p.setNombre("Santino");
        santino_p.setCorreo("srascovich@frba.utn.edu.ar");
        santino_p.setComunidades(set);
        santino_p.setMetodo_sincronizacion(metodo_sincronizacion);
        santino_p.setMetodo_notificacion(metodo_notificacion);
        Usuario santino = new Usuario();
        santino.setPerfil(santino_p);

        Perfil nico_p = new Perfil();
        nico_p.setNombre("Nico");
        nico_p.setCorreo("nsantero@frba.utn.edu.ar");
        nico_p.setComunidades(set);
        nico_p.setMetodo_sincronizacion(metodo_sincronizacion);
        nico_p.setMetodo_notificacion(metodo_notificacion);
        Usuario nico = new Usuario();
        nico.setPerfil(nico_p);

        Perfil max_p = new Perfil();
        max_p.setNombre("Max");
        max_p.setCorreo("maximiliano.duva@outlook.com");
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
        comunidad.setMiembros((Set<Usuario>) lista);

        // se inicializa la lista de incidentes y se la agrega a la comunidad
        comunidad.setListado_incidentes(new ArrayList<Incidente>());

        // se crea el establecimiento y el servicio de dicho establecimiento
        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setNombre("Medrano");
        Servicio servicio_original = new Servicio_Base();
        servicio_original.setDescripcion("Escalera");
        servicio_original.setEstablecimiento(establecimiento);

        // se carga el incidente y luego se lo cierra
        facundo.cargar_nuevo_incidente(comunidad,servicio_original, "");
        facundo.cerrar_incidente(comunidad.getListado_incidentes().iterator().next(), comunidad);
    }
}
