package ar.edu.utn.frba.dds.Domain.Notificaciones.Tipos_Notificaciones;

import ar.edu.utn.frba.dds.Domain.Incidente.Incidente;

import ar.edu.utn.frba.dds.Domain.Personas.Usuario;

import java.util.Set;

public interface Notificacion_Builder {

    Notificacion_Builder agregar_usuarios_a_notificar(Set<Usuario> usuarios_a_notificar);
    Notificacion_Builder agregar_mensaje(Incidente incidente);

    Notificacion construir();
}
