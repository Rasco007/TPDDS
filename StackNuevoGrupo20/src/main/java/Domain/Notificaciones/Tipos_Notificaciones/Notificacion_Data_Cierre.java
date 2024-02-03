package Domain.Notificaciones.Tipos_Notificaciones;

import Domain.Incidente.Incidente;
import Domain.Personas.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
public class Notificacion_Data_Cierre implements Notificacion_Builder {
    Notificacion notificacion = new Notificacion("Cierre de incidente");;
    @Override
    public Notificacion_Builder agregar_usuarios_a_notificar(Set<Usuario> usuarios_a_notificar) {
        notificacion.setUsuario_a_notificar((Set<Usuario>) usuarios_a_notificar);
        return this;
    }

    @Override
    public Notificacion_Builder agregar_mensaje(Incidente incidente) {
        notificacion.setMensaje("El establecimiento " +  incidente.getServicio_afectado().getEstablecimiento().getNombre()
                + " solucionó las fallas en el servicio " + incidente.getServicio_afectado().getDescripcion());
        return this;
    }



    @Override
    public Notificacion construir() {
        notificacion.setHorario_Notificacion(LocalDateTime.now().toLocalDate());
        return this.notificacion;
    }
}
