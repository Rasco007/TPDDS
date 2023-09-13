package Domain.Entidades;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class entidad {
    private String nombre;
    private TipoDeEntidad tipoDeEntidad;
    private Set<Establecimiento> listaDeEstablecimientos;
	
	private String localidad;
	
	    private List<entidad> entidades;

    public entidad(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }
}
