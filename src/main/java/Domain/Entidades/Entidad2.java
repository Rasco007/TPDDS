package Domain.Entidades;

import Domain.Personas.Usuario;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entidad2 {
  private List<Usuario> usuarios_asociados;
  private Usuario receptor_informacion_designado;
  private List<Establecimiento> sucursales;
  private String nombre;
}