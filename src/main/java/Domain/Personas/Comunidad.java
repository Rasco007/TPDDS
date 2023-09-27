package Domain.Personas;

import Domain.Incidente.Incidente;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table

public class Comunidad {
  public Comunidad() {
    listado_incidentes=new ArrayList<Incidente>();
    miembros_afectados=new ArrayList<Usuario>();
    administradores=new ArrayList<Usuario>();
    miembros_observadores=new ArrayList<Usuario>();
  }

  @Id
  @GeneratedValue
  private int id;
  @Column(columnDefinition = "VARCHAR")
  private String nombre;
  @OneToMany(mappedBy = "comunidad_afectada")
  private List<Incidente> listado_incidentes;



  @Transient
  private Set<Usuario> miembros;
  @ManyToMany
  @JoinTable(name = "comunidad_administrador",joinColumns = @JoinColumn(name = "comunidad",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "administrador",referencedColumnName = "id"))
  private List<Usuario> administradores;
  @ManyToMany
  @JoinTable(name = "comunidad_observador",joinColumns = @JoinColumn(name = "comunidad",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "observador",referencedColumnName = "id"))
  private List<Usuario> miembros_observadores;
  @ManyToMany
  @JoinTable(name = "comunidad_afectado",joinColumns = @JoinColumn(name = "comunidad",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "afectado",referencedColumnName = "id"))
  private List<Usuario> miembros_afectados;


  public void setMiembros(){
    for(int i=0;i<administradores.size();i++){
      miembros.add(administradores.get(i));
    }
    for(int i=0;i<miembros_observadores.size();i++){
      miembros.add(miembros_observadores.get(i));
    }
    for(int i=0;i<miembros_afectados.size();i++){
      miembros.add(miembros_afectados.get(i));
    }
  }


  //Para manejo de confianza
  private float puntos_confianza;
  public void cambiar_confianza(float cambio){
    puntos_confianza+=cambio;
  }
  public String getGradoDeConfianza(){
    if(this.puntos_confianza<2){
      return "No confiable.";
    } else if (this.puntos_confianza<=3) {
      return "Con reservas.";
    } else if (this.puntos_confianza<=5) {
      return "Confiable de nivel 1";
    }else{
      return "Confiable de nivel 2";
    }
  }

}
