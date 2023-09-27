package Domain.Notificaciones.Tipos_Notificaciones;

import Domain.Personas.Usuario;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
public class Notificacion {
    private List<Usuario> usuario_a_notificar;
    private String mensaje;
    private LocalDate horario_Notificacion;
    private String asunto;
    private Boolean enviado = false;

    public Notificacion(String asunto){
        this.asunto = asunto;
    }

    public void envioCorrecto(){
        this.setEnviado(true);
    }
}
