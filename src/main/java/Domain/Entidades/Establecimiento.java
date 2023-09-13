package Domain.Entidades;

import Domain.GeoRef.Ubicacion;
import Domain.Servicio.Servicio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Establecimiento {
  private String nombre;
  private Ubicacion ubicacion;
  private Servicio servicios;
  private Entidad entidad;
}
