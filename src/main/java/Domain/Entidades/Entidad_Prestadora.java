package Domain.Entidades;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Entidad_Prestadora {
  private String nombre;
  private List<Entidad> entidades;
}