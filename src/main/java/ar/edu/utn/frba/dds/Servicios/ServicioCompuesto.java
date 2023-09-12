package ar.edu.utn.frba.dds.Servicios;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter

public class ServicioCompuesto extends Servicio{
    private List<Servicio> servicios;
    public void agregar(Servicio servicioAAgregar){
        this.servicios.add(servicioAAgregar);
    }
    public void eliminar(Servicio servicioAEliminar){
        this.servicios.remove(servicioAEliminar);
    }
}
