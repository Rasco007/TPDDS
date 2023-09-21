package Domain.Personas;

import Domain.Incidente.Incidente;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comunidad {
  private String nombre;
  private List<Usuario> miembros;
  private List<Usuario> administradores;
  private List<Incidente> listado_incidentes;
  private List<Usuario> miembros_observadores;
  private List<Usuario> miembros_afectados;

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
