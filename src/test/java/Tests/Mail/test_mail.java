package Tests.Mail;

import Domain.Entidades.Establecimiento;
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


            m.enviarEmail("Test", "Hola mundo", "fndalsasso@gmail.com");

            System.out.println("Se ha enviado!!");
        } catch (InvalidParameterException | IOException | MessagingException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void flujoCompleto() throws MessagingException, IOException {
        Comunidad comunidad = new Comunidad();

        List<Usuario> lista = new ArrayList<Usuario>();
        Set<Comunidad> set = new HashSet<Comunidad>();

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

        usuario.getPerfil().setMetodo_sincronizacion(metodo_sincronizacion);
        usuario.getPerfil().setMetodo_notificacion(metodo_notificacion);



        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setNombre("Medrano");

        Servicio servicio_original = new Servicio_Base();
        servicio_original.setDescripcion("Escalera");

        //usuario.cargar_nuevo_incidente(establecimiento,servicio_original, "");

        //usuario.cerrar_incidente(comunidad.getListado_incidentes().iterator().next());
    }
}
