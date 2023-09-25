package Domain.GeoRef.Entidades;

import javax.persistence.*;

@Entity
@Table
public class Municipio {
  @Id
  @GeneratedValue
  public int id;
  @Column(name = "varchar2(100)")
  public String nombre;
  @OneToOne
  @JoinColumn(name = "centroide",referencedColumnName = "id")
  public Centroide centroide;
}