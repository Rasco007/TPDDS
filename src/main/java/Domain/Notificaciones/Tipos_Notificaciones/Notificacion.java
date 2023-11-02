package Domain.Notificaciones.Tipos_Notificaciones;

import Domain.Personas.Perfil;
import Domain.Personas.Usuario;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@Table
public class Notificacion {
    @Id
    @GeneratedValue
    private int id;
    @ManyToMany
    @JoinTable(name = "notificacion_usuario",
            joinColumns = @JoinColumn(name = "noficacion",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "usuario",referencedColumnName = "id"))
    private Set<Usuario> usuario_a_notificar;

    private String mensaje;
    private LocalDate horario_Notificacion;
    private String asunto;
    private Boolean enviado = false;

    //persistecia
    @ManyToMany
    @JoinTable(name = "notificacion_perfiles",
            joinColumns = @JoinColumn(name = "noficacion",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "perfil",referencedColumnName = "id"))
    private List<Perfil> perfiles_a_notificar;



    public Notificacion(String asunto){
        this.asunto = asunto;
    }

    public void envioCorrecto(){
        this.setEnviado(true);
    }
}
