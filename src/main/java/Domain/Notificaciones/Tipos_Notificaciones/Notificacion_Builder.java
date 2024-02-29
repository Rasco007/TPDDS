package Domain.Notificaciones.Tipos_Notificaciones;

import Domain.Incidente.Incidente;

import Domain.Personas.Usuario;
import java.util.List;
import java.util.Set;

public interface Notificacion_Builder {

    Notificacion_Builder agregar_usuarios_a_notificar(Set<Usuario> usuarios_a_notificar);
    Notificacion_Builder agregar_mensaje(Incidente incidente);

    Notificacion construir();
}
