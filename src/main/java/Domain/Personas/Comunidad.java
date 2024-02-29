package Domain.Personas;

import Domain.Entidades.Entidad;
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
    administradores=new ArrayList<Usuario>();
  }

  @Id
  @GeneratedValue
  private int id;
  @Column(columnDefinition = "varchar(100)")
  private String nombre;
  @Column(columnDefinition = "varchar(200)")
  private String descripcion;
  @OneToMany(mappedBy = "comunidad_afectada")
  private List<Incidente> listado_incidentes;


  @ManyToOne
  @JoinColumn(name="entidad_id")
  private Entidad entidad;

  @ManyToMany
  @JoinTable(name = "comunidad_miembro", joinColumns = @JoinColumn(name = "comunidad_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"))
  private List<Usuario> miembros;

  @ManyToMany
  @JoinTable(name = "comunidad_administrador",joinColumns = @JoinColumn(name = "comunidad",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "administrador",referencedColumnName = "id"))
  private List<Usuario> administradores;



  public boolean estaElMiembro(Usuario u) {
    for (int i = 0; i < this.getMiembros().size(); i++) {
      if (this.getMiembros().get(i) == u) {
        return true;
      }

    }
    return false;
  }

  public boolean estaElAdmin(Usuario u) {
    for (int i = 0; i < this.getAdministradores().size(); i++) {
      if (this.getAdministradores().get(i) == u) {
        return true;
      }

    }
    return false;
  }

    public void setMiembro(Usuario u){
      if (this.getMiembros() == null) {
        this.setMiembros(new ArrayList<>()); // Inicializa la lista si es nula
      }
    this.getMiembros().add(u);

  }

  public void setAdmin(Usuario u){
    this.getAdministradores().add(u);

  }
  public void setMiembros(){
    for(int i=0;i<administradores.size();i++){
      miembros.add(administradores.get(i));
    }


  }

  public void removeMiembro(Usuario u){
    for(int i=0;i<getMiembros().size();i++){
      if (this.getMiembros().get(i) == u) {
        getMiembros().remove(i);

      }
    }


  }



  //Para manejo de confianza
  private float puntos_confianza;
  public void cambiar_confianza(float cambio){
    puntos_confianza+=cambio;
  }
  public String get_grado_confianza(){
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
