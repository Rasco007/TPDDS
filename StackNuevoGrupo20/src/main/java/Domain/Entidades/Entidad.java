package Domain.Entidades;

import Domain.GeneradorDeRankings.Ranking;
import Domain.Personas.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "entidad")
public class Entidad {
  public Entidad() {}


  @Id
  @GeneratedValue
  private int id;
  @ManyToMany
  @JoinTable(name = "entidad_usuario",joinColumns = @JoinColumn(name = "entidad_id",referencedColumnName = "id")
                      ,inverseJoinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"))
  private List<Usuario> usuarios_asociados;
  @OneToOne
  @JoinColumn(name = "receptorDeInfo_id", referencedColumnName = "id")
  private Usuario receptor_informacion_designado;
  @OneToMany(mappedBy = "entidad")
  private List<Establecimiento> sucursales;
  @Column(columnDefinition = "varchar(100)")
  private String nombre;

  //rankings
  @OneToOne
  @JoinColumn(name = "rankingTiempoDeCierre",referencedColumnName = "id")
  private Ranking rankingTiempoDeCierre;
  @OneToOne
  @JoinColumn(name = "rankingImpacto",referencedColumnName = "id")
  private Ranking rankingImpacto;
  @OneToOne
  @JoinColumn(name = "rankingIncidentes",referencedColumnName = "id")
  private Ranking rankingCantIncidentes;



  //Persistenciasç
  @ManyToMany(mappedBy = "entidades")
  private List<Entidad_Prestadora> prestadoras;
  @ManyToMany(mappedBy = "entidades")
  private List<Organismo_Control> organismos;

}