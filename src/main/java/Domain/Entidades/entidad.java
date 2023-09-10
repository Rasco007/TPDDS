package Domain.entidades;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Entidad {
    private String nombre;
    private TipoDeEntidad tipoDeEntidad;
    private Set<Establecimiento> listaDeEstablecimientos;
	
	private String localidad
	
	    private List<Entidad> entidades;



    public Entidad(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

}

	

}
