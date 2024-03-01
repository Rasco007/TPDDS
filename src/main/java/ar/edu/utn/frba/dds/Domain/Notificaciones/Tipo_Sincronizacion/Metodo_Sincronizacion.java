package ar.edu.utn.frba.dds.Domain.Notificaciones.Tipo_Sincronizacion;

import ar.edu.utn.frba.dds.Domain.Notificaciones.Tipos_Notificaciones.Notificacion;
import ar.edu.utn.frba.dds.Domain.Personas.Usuario;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Metodo_Sincronizacion {

    void notificar(Usuario usuario, Notificacion notificacion) throws MessagingException, IOException;
}
