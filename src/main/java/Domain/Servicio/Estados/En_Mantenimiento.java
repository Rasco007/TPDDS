package Domain.Servicio.Estados;

import Domain.Servicio.Estados.Estado_Servicio;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "En_Mantenimiento")
public class En_Mantenimiento extends Estado_Servicio {

  public void habilitar(){
  }
}
