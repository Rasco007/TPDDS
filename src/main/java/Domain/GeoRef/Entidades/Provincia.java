package Domain.GeoRef.Entidades;

import javax.persistence.*;

@Entity
@Table
public class Provincia {
  @Id
  @GeneratedValue
  public int id;
  @Column(name = "varchar(100)")
  public String nombre;
}
