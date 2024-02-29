package Domain.Personas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Comunidad_miembro")
public class Comunidad_miembro implements Serializable {


    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "comunidad_id",referencedColumnName = "id")
    private Comunidad comunidad;


}
