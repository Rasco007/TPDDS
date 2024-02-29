package Domain.Entidades;

import Domain.GeneradorDeRankings.Ranking;
import Domain.Grupo8.Incident;
import Domain.Incidente.Incidente;
import Domain.Personas.Comunidad;
import Domain.Personas.Usuario;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "entidad")
public class Entidad {



  @Id
  @GeneratedValue
  private int id;

  @ManyToOne
  @JoinColumn(name="usuario_id")
  private Usuario usuario_creador;

  @OneToOne
  @JoinColumn(name = "receptorDeInfo_id", referencedColumnName = "id")
  private Usuario receptor_informacion_designado;
  @OneToMany(mappedBy = "entidad")
  private List<Establecimiento> sucursales;
  @Column(columnDefinition = "varchar(100)")
  private String nombre;

  @OneToMany(mappedBy="entidad")
  private List<Comunidad> comunidades;

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
  @OneToMany(mappedBy = "entidad")
  private List<Organismo_Control> organismosControl;

  @OneToMany(mappedBy = "entidad")
  private List<Entidad_Prestadora> prestadoras;

  public void setComunidad(Comunidad u){
    this.getComunidades().add(u);

  }

}