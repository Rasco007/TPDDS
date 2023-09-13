package Domain.Servicio;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servicio_Compuesto extends Servicio{
  private List<Servicio> servicios;

  public void agregar(Servicio servicio){
    servicios.add(servicio);
  }

  public void eliminar(Servicio servicio){
    servicios.remove(servicio);
  }
}
