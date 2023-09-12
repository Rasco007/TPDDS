package Domain.Notificacion;

import Domain.personas.Miembro;
import Domain.services.georef.ServicioGeoref;
import Domain.Notificacion.TiposDeNotificaciones.Notificacion;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Notificador {
  private static Notificador instancia = null;


  public static Notificador instancia(){
    if(instancia== null){
      instancia = new Notificador();
    }
    return instancia;
  }
  public void notificar(Notificacion notificacion) throws MessagingException, IOException {
    //Set<Miembro> todosMiembros = notificacion.getMiembrosANotificar();

    for(Miembro miembro: notificacion.getMiembrosANotificar()){
      miembro.getPersona().getTipoDeSincronazicacion().notificar(miembro, notificacion);
    }
    notificacion.envioCorrecto();
  }
}
