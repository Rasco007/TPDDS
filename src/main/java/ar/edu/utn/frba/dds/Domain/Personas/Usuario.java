package ar.edu.utn.frba.dds.Domain.Personas;

import ar.edu.utn.frba.dds.Domain.Entidades.Entidad;
import ar.edu.utn.frba.dds.Domain.GeoRef.Entidades.Centroide;
//import Domain.GeoRef.Servicio;
import ar.edu.utn.frba.dds.Domain.Servicio.Servicio;
import ar.edu.utn.frba.dds.Domain.Incidente.Incidente;
import java.io.IOException;
import javax.mail.MessagingException;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
  public Usuario() {
    this.roles=new ArrayList<Rol>();
  }

  @Id
  @GeneratedValue
  private int id;
  @Column(name = "login")
  private String login;
  @Column
  private String password;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "perfil_id",referencedColumnName = "id")
  private Perfil perfil;
  @ManyToMany
  @JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
                inverseJoinColumns =@JoinColumn(name = "rol_id",referencedColumnName = "id") )
  private List<Rol> roles;
  @Transient
  private Centroide ubicacion;


  //persitencias
  @OneToMany(mappedBy="usuario_creador")
  private List<Entidad> entidades;

  @ManyToMany(mappedBy = "miembros")
  private List<Comunidad> comunidades;



  public boolean estaUnido(Comunidad u) {
    return this.getComunidades().contains(u);

  }

  public void setEntidad(Entidad u){
    if (this.getEntidades() == null) {
      this.setEntidades(new ArrayList<>()); // Inicializa la lista si es nula
    }
    this.getEntidades().add(u);

  }
  public void setComunidad(Comunidad c){
    if (!this.getComunidades().contains(c)) {
      this.getComunidades().add(c);
    }
  }


  public void removeComunidad(Comunidad u){
    Iterator<Comunidad> iterator = getComunidades().iterator();
    while (iterator.hasNext()) {
      Comunidad comunidad = iterator.next();
      if (comunidad.equals(u)) {
        iterator.remove();
      }
    }


  }


  public void cargar_nuevo_incidente(Comunidad comunidad, Servicio servicio, String observaciones) throws MessagingException, IOException {
    /*Incidente incidente = new Incidente(servicio, observaciones, comunidad);
    incidente.crear_incidente((List<Usuario>) comunidad.getMiembros());
    comunidad.getListado_incidentes().add(incidente);*/

  }

  public void cerrar_incidente(Incidente incidente, Comunidad comunidad) throws MessagingException, IOException {
    /*incidente.cerrar_incidente((List<Usuario>) comunidad.getMiembros());
    comunidad.getListado_incidentes().remove(incidente);*/
  }
}
