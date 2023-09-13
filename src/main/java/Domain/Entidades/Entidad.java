package Domain.Entidades;


import Domain.Personas.Usuario;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Entidad {
    private List<Usuario> usuarios_asociados;
    private Usuario receptor_informacion_designado;
    private List<Establecimiento> sucursales;
    private String nombre;
}
