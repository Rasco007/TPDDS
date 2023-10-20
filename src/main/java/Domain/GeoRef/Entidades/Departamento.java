package Domain.GeoRef.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Departamento{
  @Id
  @GeneratedValue
  public int id;
  @Column(name = "varchar(100)")
  public String nombre;
  @OneToOne
  @JoinColumn(name = "centroide",referencedColumnName = "id")
  public Centroide centroide;
  @OneToMany(mappedBy = "departamento")
  public Set<Localidad> localidades;

}
