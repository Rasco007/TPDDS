package Domain.Servicio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class Servicio_Base extends Servicio {

    //persistencia
    @ManyToOne
    @JoinColumn(name="pertenece_a",referencedColumnName = "id")
    private Servicio_Compuesto pertenece_a;
}