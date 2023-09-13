package Domain.GeoRef;

import Domain.GeoRef.Entidades.Departamento;
import Domain.GeoRef.Entidades.Localidad;
import Domain.GeoRef.Entidades.Municipio;
import Domain.GeoRef.Entidades.Provincia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ubicacion {
  private Localidad localidad;
  private Departamento departamento;
  private Provincia provincia;
  private Municipio municipio;
}
