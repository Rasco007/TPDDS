package ar.edu.utn.frba.dds.Domain.Notificaciones;


import ar.edu.utn.frba.dds.Domain.Notificaciones.api_whatsapp.Servicio_Whatsapp;
import ar.edu.utn.frba.dds.Domain.Personas.Usuario;

public class Whatsapp implements Metodo_Notificacion {
    public void notificar(Usuario usuario, String mensaje, String asunto){
        Servicio_Whatsapp.enviarMensaje(usuario.getPerfil().getTelefono(), mensaje, asunto);
    }
}
