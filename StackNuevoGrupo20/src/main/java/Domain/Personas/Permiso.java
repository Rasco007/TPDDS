package Domain.Personas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Permiso {
  @Id
  @GeneratedValue
  private int id;
  @Column
  private String descripcion;

  //persistencia
  @ManyToMany(mappedBy = "permisos")
  private List<Rol> roles;
}
