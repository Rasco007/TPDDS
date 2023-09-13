package Domain.Servicio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Estado_Servicio {
  private String descripcion;

  public void realizar_mantenimiento() {
  }

  public void habilitar(){
  }

  public void clausurar(){
  }
}
