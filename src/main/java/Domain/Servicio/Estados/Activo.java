package Domain.Servicio.Estados;

import Domain.Servicio.Estados.Estado_Servicio;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "Activo")
public class Activo extends Estado_Servicio {

  public void clausurar(){
  }
}
