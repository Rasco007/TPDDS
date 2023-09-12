package Domain.entidades;

import ar.edu.utn.frba.dds.Entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class OrganismoDeControl {
    private String nombre;
    private List<Entidad> entidades;
	

    public OrganismoDeControl(String nombre) {
        this.nombre = nombre;
    }
}
