package Domain.GeoRef.Entidades;

import javax.persistence.*;

@Entity
@Table
public class Centroide {
  @Id
  @GeneratedValue
  private int id;
  @Column
  public float lat;
  @Column
  public float lon;
}
