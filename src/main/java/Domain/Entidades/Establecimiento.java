package Domain.Entidades;

import Domain.GeoRef.Ubicacion;
import Domain.Incidente.Incidente;
import Domain.Servicio.Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "establecimiento")
public class Establecimiento {
  @Id
  @GeneratedValue
  private int id;
  @Column(columnDefinition = "varchar(100)")
  private String nombre;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ubicacion_id",referencedColumnName = "id")
  private Ubicacion ubicacion;
  @ManyToMany
  @JoinTable(
          name = "establecimiento_servicio",
          joinColumns = @JoinColumn(name = "establecimiento_id"),
          inverseJoinColumns = @JoinColumn(name = "servicio_id")
  )  @JoinColumn(name = "servicio_id",referencedColumnName = "id")
  private List<Servicio> servicios;
  @ManyToOne
  @JoinColumn(name = "entidad_id",referencedColumnName = "id")
  private Entidad entidad;

  @OneToMany(mappedBy = "establecimiento")
  private List<Incidente> incidentes;

}
