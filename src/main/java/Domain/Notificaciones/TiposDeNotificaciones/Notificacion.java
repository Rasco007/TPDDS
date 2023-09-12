package Domain.Notificacion.TiposDeNotificaciones;

import Domain.personas.Miembro;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
public class Notificacion {
    private Set<Miembro> miembrosANotificar;
    private String mensaje;
    private LocalDate horarioDeNotificacion;
    private String asunto;
    private Boolean enviado = false;

    public Notificacion(String asunto){
        this.asunto = asunto;
    }

    public void envioCorrecto(){
        this.setEnviado(true);
    }
}
