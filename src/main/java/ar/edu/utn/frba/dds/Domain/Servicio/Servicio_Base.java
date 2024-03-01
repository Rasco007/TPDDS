package ar.edu.utn.frba.dds.Domain.Servicio;

import ar.edu.utn.frba.dds.Domain.Servicio.Estados.Activo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
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