package ar.edu.utn.frba.dds.Domain.Personas;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Rol {
  @Id
  @GeneratedValue
  private int id;
  @Column
  private String nombre;
  @ManyToMany
  @JoinTable(name = "rol_permisos",joinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "permisos_id",referencedColumnName = "id"))
  private List<Permiso> permisos;

  //persistencia
  @ManyToMany(mappedBy = "roles")
  private List<Usuario> usuarios;

  public boolean tenes_permiso(Permiso permiso){
    return permisos.contains(permiso);
  }
}
