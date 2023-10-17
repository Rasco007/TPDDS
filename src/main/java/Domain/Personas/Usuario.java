package Domain.Personas;

import Domain.Entidades.Entidad;
import Domain.GeoRef.Entidades.Centroide;
import Domain.GeoRef.Servicio;
import Domain.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
  @Id
  @GeneratedValue
  private int id;
  @Column(name = "login")
  private String login;
  @Column
  private String password;
  @OneToOne
  @JoinColumn(name = "perfil_id",referencedColumnName = "id")
  private Perfil perfil;
  @ManyToMany
  @JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
                inverseJoinColumns =@JoinColumn(name = "rol_id",referencedColumnName = "id") )
  private List<Rol> roles;
  @Transient
  private Centroide ubicacion;


  //persitencias
  @ManyToMany(mappedBy = "usuarios_asociados")
  private List<Entidad> entidades;
  @ManyToMany(mappedBy = "administradores")
  private List<Comunidad> comunidades_admin;
  @ManyToMany(mappedBy = "miembros_observadores")
  private List<Comunidad> comunidades_observador;
  @ManyToMany(mappedBy = "miembros_afectados")
  private List<Comunidad> comunidades_afectados;





  public Incidente cargar_nuevo_incidente(Comunidad comunidad){
    return new Incidente();
  };

  public void cerrar_incidente(Incidente incidente){};
}
