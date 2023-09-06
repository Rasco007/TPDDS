package ar.edu.utn.frba.dds.Servicios;

import ar.edu.utn.frba.dds.Establecimiento.Establecimiento;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class Servicio {

    private ar.edu.utn.frba.dds.Servicios.EstadoDelServicio estado;
    private String descripcion;
    private List<Usuario> usuarios;
    private Establecimiento establecimiento;

}
