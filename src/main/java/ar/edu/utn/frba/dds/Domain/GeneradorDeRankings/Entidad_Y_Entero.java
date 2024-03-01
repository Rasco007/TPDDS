package ar.edu.utn.frba.dds.Domain.GeneradorDeRankings;

import ar.edu.utn.frba.dds.Domain.Entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entidad_Y_Entero {
    public Entidad entidad;
    public long cant;

    public Entidad_Y_Entero(Entidad entidad) {
        this.entidad = entidad;
        this.cant= 0;
    }



}
