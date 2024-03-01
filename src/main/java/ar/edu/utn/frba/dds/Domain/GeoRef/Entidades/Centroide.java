package ar.edu.utn.frba.dds.Domain.GeoRef.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table
public class Centroide {
  @Id
  @GeneratedValue
  public int id;
  @Column(name = "lat")
  public float lat;
  @Column(name = "lon")
  public float lon;
}
