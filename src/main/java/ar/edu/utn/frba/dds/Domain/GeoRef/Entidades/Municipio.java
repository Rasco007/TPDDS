package ar.edu.utn.frba.dds.Domain.GeoRef.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table
public class Municipio {
  @Id
  @GeneratedValue
  public int id;
  @Column(name = "nombre")
  public String nombre;

}