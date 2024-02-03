package Domain.Servicio.Estados;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "inactivo")
public class Inactivo extends Estado_Servicio {
  public void realizar_mantenimiento() {
  }
}
