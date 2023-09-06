package ar.edu.utn.frba.dds.GeneradorDeRankings;
import Domain.entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class EntidadYEntero {
    public Domain.entidades.Entidad entidad;
    public Integer cant;

    public EntidadYEntero(Entidad entidad) {
        this.entidad = entidad;
        this.cant=1;
    }
}
