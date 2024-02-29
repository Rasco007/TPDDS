package Domain.Servicio;

import Domain.Servicio.Estados.Activo;
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

    public Servicio_Base() {
        setEstado_servicio(new Activo());
    }


}