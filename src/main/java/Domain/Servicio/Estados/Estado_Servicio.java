package Domain.Servicio.Estados;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "estados_servicio")
@DiscriminatorColumn(name = "estado")
public abstract class Estado_Servicio {
  @Id
  @GeneratedValue
  private int id;
  @Column(columnDefinition = "varchar2(100)")
  private String descripcion;

  public void realizar_mantenimiento() {
  }

  public void habilitar(){
  }

  public void clausurar(){
  }
}
