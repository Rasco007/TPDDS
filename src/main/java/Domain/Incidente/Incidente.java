package Domain.Incidente;
import Domain.Notificaciones.Notificador;
import Domain.Notificaciones.Tipos_Notificaciones.Notificacion;
import Domain.Notificaciones.Tipos_Notificaciones.Notificacion_Builder;
import Domain.Notificaciones.Tipos_Notificaciones.Notificacion_Data;
import Domain.Notificaciones.Tipos_Notificaciones.Notificacion_Data_Cierre;
import Domain.Personas.Comunidad;
import Domain.Personas.Usuario;
import Domain.Servicio.Servicio;
import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Incidente {
    private Servicio servicio_afectado;
    private Timestamp fecha_hora_de_inicio;
    private Timestamp fecha_Hora_de_cierre;
    private String observaciones;
    private Boolean resuelto;
    private Comunidad comunidad_afectada;
    private Notificacion_Builder notificacionAbrir = new Notificacion_Data();
    private Notificacion_Builder notificacionCerrar = new Notificacion_Data_Cierre();
    public Incidente(Servicio servicio_afectado, String observaciones, Comunidad comunidad_afectada){
        this.servicio_afectado = servicio_afectado;
        Long datetime = System.currentTimeMillis();
        this.fecha_hora_de_inicio = new Timestamp(datetime);
        this.fecha_Hora_de_cierre = null;
        this.observaciones = observaciones;
        this.resuelto = false;
        this.comunidad_afectada = comunidad_afectada;
    }

    public void cerrar_incidente(List<Usuario> miembros_a_notificar) throws MessagingException, IOException {
        this.setResuelto(false);
        Long datetime = System.currentTimeMillis();
        this.setFecha_Hora_de_cierre(new Timestamp(datetime));

        Notificacion data = notificacionCerrar.agregar_usuarios_a_notificar(miembros_a_notificar)
            .agregar_mensaje(this).construir();
        Notificador.instancia().notificar(data);
    }
    public void crear_incidente(List<Usuario> miembros_notificar) throws MessagingException, IOException {
        Notificacion data = notificacionAbrir.agregar_usuarios_a_notificar(miembros_notificar)
            .agregar_mensaje(this).construir();
        Notificador.instancia().notificar(data);
    }
}
