package ar.edu.utn.frba.dds.Domain.Notificaciones;

import ar.edu.utn.frba.dds.Domain.Personas.Usuario;
import ar.edu.utn.frba.dds.Domain.Notificaciones.Tipos_Notificaciones.Notificacion;

import javax.mail.MessagingException;
import java.io.IOException;

public class Notificador {
  private static Notificador instancia = null;

  public static Notificador instancia(){
    if(instancia== null){
      instancia = new Notificador();
    }
    return instancia;
  }
  public void notificar(Notificacion notificacion) throws MessagingException, IOException {

    for(Usuario usuario: notificacion.getUsuario_a_notificar()){
      usuario.getPerfil().getMetodo_sincronizacion().notificar(usuario, notificacion);
    }
    notificacion.envioCorrecto();
  }
}
