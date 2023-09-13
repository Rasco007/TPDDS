package Domain.Entidades;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class organismoControl {
    private String nombre;
    private List<entidad> entidades;
	

    public organismoControl(String nombre) {
        this.nombre = nombre;
    }
}
