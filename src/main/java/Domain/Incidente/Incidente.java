package Domain.Incidente;
import Domain.Comunidad.Comunidad;
import Domain.Servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Incidente {
    private Servicio servicioAfectado;
    private Timestamp fechaYHoraDeInicio;
    private Timestamp FechaYHoraDeCierre;
    private String observaciones;
    private Boolean resuelto;
    private Comunidad comunidadAfectada;
}
