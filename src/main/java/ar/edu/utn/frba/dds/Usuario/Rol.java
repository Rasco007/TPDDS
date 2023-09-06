package ar.edu.utn.frba.dds.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
public class Rol {
    private String nombre;
    private List<Permiso> permisos;

    public Boolean tenesPermiso(Permiso permisoConcreto){
        return this.permisos.contains(permisoConcreto);
    }
}
