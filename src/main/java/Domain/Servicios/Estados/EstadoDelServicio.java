package Domain.Servicios.Estados;
import lombok.Getter;
import lombok.Setter;

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