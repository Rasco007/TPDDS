package Domain.Personas;

import Domain.GeoRef.Ubicacion;
import Domain.Incidente.Incidente;
import Domain.Notificaciones.Metodo_Notificacion;
import Domain.Notificaciones.Tipo_Sincronizacion.Metodo_Sincronizacion;
import Domain.Notificaciones.Tipos_Notificaciones.Notificacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@Table
public class Perfil {
  @Id
  @GeneratedValue
  private int id;
  @Column(columnDefinition = "varchar(100)")
  private String nombre;
  @Column(columnDefinition = "varchar(100)")
  private String apellido;
  @Column(columnDefinition = "varchar(100)")
  private String correo;
  @Column(columnDefinition = "varchar(100)")
  private String telefono;
  @Transient
  private Set<Comunidad> comunidades;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ubicacionDeInteres_id",referencedColumnName = "id")
  private Ubicacion ubicacion_interes;
  //TODO
  //@Column (columnDefinition = "String")
  @Transient
  private Metodo_Notificacion metodo_notificacion;
  @ManyToMany(mappedBy = "perfiles_a_notificar")
  private List<Notificacion> notificaciones_a_dar;
  @Column
  private LocalDateTime horario_notificacion;
  //Todo converter
  @Transient
  private Metodo_Sincronizacion metodo_sincronizacion;
  @OneToOne(mappedBy = "perfil")
  private Usuario usuario;
  //para confianza
  @Column
  private float puntosDeConfianza;
  @OneToMany(mappedBy = "usuario_iniciador")
  private List<Incidente> incidentesAbiertos;
  @OneToMany(mappedBy = "usuario_finalizador")
  private List<Incidente> incidentesCerrados;

  public void cambiar_confianza(float cambio){
    puntosDeConfianza+=cambio;
  }

  public String getGrado_confianza(){
    if(this.puntosDeConfianza<2){
      return "No confiable.";
    } else if (this.puntosDeConfianza<=3) {
      return "Con reservas.";
    } else if (this.puntosDeConfianza<=5) {
      return "Confiable de nivel 1";
    }else{
      return "Confiable de nivel 2";
    }
  }

  public void iniciarComunidades(){
      for(int i=0;i<usuario.getComunidades_admin().size();i++){
        comunidades.add(usuario.getComunidades_admin().get(i));
      }
      for(int i=0;i<usuario.getComunidades_observador().size();i++){
        comunidades.add(usuario.getComunidades_observador().get(i));

      }
      for(int i=0;i<usuario.getComunidades_afectados().size();i++){
        comunidades.add(usuario.getComunidades_afectados().get(i));
      }

  }

  public Perfil() {
  }
}
