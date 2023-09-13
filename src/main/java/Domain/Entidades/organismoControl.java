package Domain.Entidades;

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
