package Domain.Servicio.Estados;

import Domain.Servicio.Estados.Estado_Servicio;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "inactivo")
public class Inactivo extends Estado_Servicio {
  public void realizar_mantenimiento() {
  }
}
