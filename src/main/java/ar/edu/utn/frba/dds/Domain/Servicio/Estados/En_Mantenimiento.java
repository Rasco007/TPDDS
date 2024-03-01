package ar.edu.utn.frba.dds.Domain.Servicio.Estados;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "En_Mantenimiento")
public class En_Mantenimiento extends Estado_Servicio {

  public void habilitar(){
  }
}
