package Domain.Notificaciones.Tipo_Sincronizacion;

import Domain.Notificaciones.Tipos_Notificaciones.Notificacion;
import Domain.Personas.Usuario;

public class Sin_Apuro implements Metodo_Sincronizacion {


    @Override
    public void notificar(Usuario usuario, Notificacion notificacion) {
        usuario.getPerfil().getNotificaciones_a_dar().add(notificacion);
    }

}
