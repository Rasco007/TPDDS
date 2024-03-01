package ar.edu.utn.frba.dds.Domain.GeoRef.Entidades;

import javax.persistence.*;

@Entity
@Table
public class Provincia {
  @Id
  @GeneratedValue
  public int id;
  @Column(name = "nombre")
  public String nombre;
}
