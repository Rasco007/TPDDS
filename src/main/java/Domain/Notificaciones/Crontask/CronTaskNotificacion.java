package Domain.Notificaciones.Crontask;

import Domain.Notificacion.TiposDeNotificaciones.Notificacion;
import Domain.Notificacion.TipoDeSincronizacion.SinApuro;
import Domain.personas.Miembro;
import Domain.personas.Persona;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class CronTaskNotificacion {

    public static void main(String[] args) {
        Set<Usuario> todos_los_usuarios = null; // Consume los miembros de la DB
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                for(Usuario usuario: todos_los_usuarios){
                    try {
                        if(LocalDateTime.now().equals(usuario.perfil.getHorarioDeNotificacion())){
                            String mensaje = null;
                            for(Notificacion noti: usuario.perfil.getNotificacionesAcumuladas()){
                                if(ChronoUnit.HOURS.between(LocalDate.now(), noti.getHorarioDeNotificacion()) <= 24)
                                    mensaje += noti.getMensaje();
                                mensaje += " ; ";
                            }
                            usuario.perfil.getMetodoDeNotificacion().notificar(usuario, mensaje, "Resumen de notificaciones");
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
