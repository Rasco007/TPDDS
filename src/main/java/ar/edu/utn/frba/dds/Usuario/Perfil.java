package ar.edu.utn.frba.dds.Usuario;

import ar.edu.utn.frba.dds.Comunidad.Comunidad;
import ar.edu.utn.frba.dds.Establecimiento.Establecimiento;
import ar.edu.utn.frba.dds.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
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


}
