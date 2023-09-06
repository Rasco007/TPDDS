package ar.edu.utn.frba.dds.Incidente;
import ar.edu.utn.frba.dds.Servicios.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;
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
