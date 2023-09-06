package ar.edu.utn.frba.dds.Servicios;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public abstract class EstadoDelServicio {

    protected EstadoDelServicio estado;
    private String descripcion;

    public abstract void clausurar();
    public abstract void habilitar();

    public abstract void realizarMantenimiento();
}

}