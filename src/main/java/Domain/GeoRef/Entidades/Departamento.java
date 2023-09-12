package Domain.GeoRef.Entidades;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Departamento{
  public int id;
  public String nombre;
  public Centroide centroide;
  public Set<Localidad> localidades;

}
