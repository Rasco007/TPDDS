package Domain.GeoRef;

import Domain.GeoRef.Entidades.Departamento;
import Domain.GeoRef.Entidades.Localidad;
import Domain.GeoRef.Entidades.Municipio;
import Domain.GeoRef.Entidades.Provincia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Ubicacion {
  @Id
  @GeneratedValue
  private int id;

  @Column
  private Double latitud;
  @Column
  private Double longitud;

  public Ubicacion(){

  }
  public Ubicacion(Double i, Double i1) {
    latitud = i;
    longitud = i1;
  }
  /*
  @OneToOne
  @JoinColumn(name = "Localidad",referencedColumnName = "id")
  private Localidad localidad;
  @OneToOne
  @JoinColumn(name = "departamento",referencedColumnName = "id")
  private Departamento departamento;
  @OneToOne
  @JoinColumn(name = "provincia",referencedColumnName = "id")
  private Provincia provincia;
  @OneToOne
  @JoinColumn(name = "municipio",referencedColumnName = "id")
  private Municipio municipio;*/
}
