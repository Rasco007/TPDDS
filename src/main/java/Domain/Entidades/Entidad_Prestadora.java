package Domain.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "entidad_prestadora")
public class Entidad_Prestadora {
  @Id
  @GeneratedValue
  private int id;
  @Column(columnDefinition = "varchar(100)")
  private String nombre;

  @ManyToOne
  @JoinColumn(name = "entidad_id")
  private Entidad entidad;
}