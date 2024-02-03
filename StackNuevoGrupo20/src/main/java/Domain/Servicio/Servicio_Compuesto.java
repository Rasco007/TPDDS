package Domain.Servicio;

import Domain.Servicio.Estados.Activo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Servicio_Compuesto extends Servicio{

  public Servicio_Compuesto() {
    setEstado_servicio(new Activo());
    servicios=new ArrayList<Servicio>();
  }
  @OneToMany(mappedBy = "pertenece_a")
  private List<Servicio> servicios;

  public void agregar(Servicio servicio){
    servicios.add(servicio);
  }

  public void eliminar(Servicio servicio){
    servicios.remove(servicio);
  }
}
