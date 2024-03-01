package ar.edu.utn.frba.dds.Domain.Notificaciones.Tipos_Notificaciones;

import ar.edu.utn.frba.dds.Domain.Personas.Usuario;
import ar.edu.utn.frba.dds.Domain.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
public class Revision_Manual implements Notificacion_Builder {
    Notificacion notificacion = new Notificacion("Revision manual de incidente");;


    @Override
    public Notificacion_Builder agregar_usuarios_a_notificar(Set<Usuario> usuarios_a_notificar) {
        notificacion.setUsuario_a_notificar((Set<Usuario>) usuarios_a_notificar);
        return this;
    }

    @Override
    public Notificacion_Builder agregar_mensaje(Incidente incidente) {
        notificacion.setMensaje("Le pedimos por favor si se tomaria la molestia de revisar el servicio "
                + incidente.getServicio_afectado().getDescripcion() +
                "del establecimiento " + incidente.getEstablecimiento().getEntidad().getSucursales().get(1).getNombre());
        return this;
    }



    @Override
    public Notificacion construir() {
        notificacion.setHorario_Notificacion(LocalDateTime.now().toLocalDate());
        return this.notificacion;
    }
}