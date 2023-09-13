package Domain.Usuario;

import Domain.Comunidad.Comunidad;
import Domain.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter


public class Perfil {


    private String nombre;
    private String apellido;
    private String correo;
    private List<Comunidad> comunidades;
    private UbicacionDeInteres ubicacionDeInteres;
    private NotificacionBuilder configNotificacion;
    private AdapterEnvioNotificaciones adapterNotificacion;
    private ConfiguracionNotificacion configuracionNotificacion;
    private MedioNotificador medioNotificador;




    //para confianza
    private float puntosDeConfianza;
    private List<Incidente> incidentesAbiertos;
    private List<Incidente> incidentesCerrados;

    public void cambiarConfianza(float cambio){
        puntosDeConfianza+=cambio;
    }

    public String getGradoDeConfianza(){
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
