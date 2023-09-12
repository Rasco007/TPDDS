package ar.edu.utn.frba.dds.Servicios;

import ar.edu.utn.frba.dds.Establecimiento.Establecimiento;
import ar.edu.utn.frba.dds.Incidente.Incidente;
import ar.edu.utn.frba.dds.Usuario.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Servicio {

    private ar.edu.utn.frba.dds.Servicios.EstadoDelServicio estado;
    private String descripcion;
    private List<Usuario> usuarios;
    private Establecimiento establecimiento;
    private List<Incidente> incidentes;

}
