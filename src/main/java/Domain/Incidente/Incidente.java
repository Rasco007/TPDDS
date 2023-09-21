package Domain.Incidente;
import Domain.Personas.Comunidad;
import Domain.Servicio.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Incidente {
    private Servicio servicio_afectado;
    private Timestamp fecha_hora_de_inicio;
    private Timestamp Fecha_Hora_de_cierre;
    private String observaciones;
    private Boolean resuelto;
    private Comunidad comunidad_afectada;
}
