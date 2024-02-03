package Domain.Notificaciones.crontask;

import Domain.Notificaciones.Tipos_Notificaciones.Notificacion;
import Domain.Personas.Usuario;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Crontask_Notificacion {

    public static void main(String[] args) {
        Set<Usuario> todos_los_usuarios = null; // Consume los miembros de la DB
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                for(Usuario usuario: todos_los_usuarios){
                    try {
                        if(LocalDateTime.now().equals(usuario.getPerfil().getHorario_notificacion())){
                            String mensaje = null;
                            for(Notificacion noti: usuario.getPerfil().getNotificaciones_a_dar()){
                                if(ChronoUnit.HOURS.between(LocalDate.now(), noti.getHorario_Notificacion()) <= 24)
                                    mensaje += noti.getMensaje();
                                mensaje += " ; ";
                            }
                            usuario.getPerfil().getMetodo_notificacion().notificar(usuario, mensaje, "Resumen de notificaciones");
                        }
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, 0, 60000); // 60000 es 1 minuto
    }

}
