package ar.edu.utn.frba.dds.Domain.GeoRef.Entidades;

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
  @Column(name = "nombre")
  public String nombre;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "centroide_id",referencedColumnName = "id")
  public Centroide centroide;
  @OneToMany(mappedBy = "departamento")
  public Set<Localidad> localidades;

}
