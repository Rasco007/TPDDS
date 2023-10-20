package Domain.Entidades;

import Domain.GeoRef.Ubicacion;
import Domain.Servicio.Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Establecimiento {
  @Id
  @GeneratedValue
  private int id;
  @Column(columnDefinition = "varchar(100)")
  private String nombre;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ubicacion_id",referencedColumnName = "id")
  private Ubicacion ubicacion;
  @OneToMany(mappedBy = "establecimiento")
  private List<Servicio> servicios;
  @ManyToOne
  @JoinColumn(name = "entidad_id",referencedColumnName = "id")
  private Entidad entidad;

}
