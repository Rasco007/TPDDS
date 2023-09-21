package Domain.Personas;

import Domain.GeoRef.Ubicacion;
import Domain.Incidente.Incidente;
import Domain.Notificaciones.Metodo_Notificacion;
import Domain.Notificaciones.Tipo_Sincronizacion.Metodo_Sincronizacion;
import Domain.Notificaciones.Tipos_Notificaciones.Notificacion;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter

public class Perfil {
  private String nombre;
  private String apellido;
  private String correo;
  private String telefono;
  private Set<Comunidad> comunidades;
  private Ubicacion ubicacion_interes;
  private Metodo_Notificacion metodo_notificacion;
  private List<Notificacion> notificaciones_a_dar;
  private LocalDateTime horario_notificacion;
  private Metodo_Sincronizacion metodo_sincronizacion;

  //para confianza
  private float puntosDeConfianza;
  private List<Incidente> incidentesAbiertos;
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
}
