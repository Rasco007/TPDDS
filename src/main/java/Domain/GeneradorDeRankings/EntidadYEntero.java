package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntidadYEntero {
    public Entidad entidad;
    public long cant;

    public EntidadYEntero(Entidad entidad) {
        this.entidad = entidad;
        this.cant= 0;
    }



}
