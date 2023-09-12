package ar.edu.utn.frba.dds.GeneradorDeRankings;
import Domain.entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class EntidadYEntero {
    public Domain.entidades.Entidad entidad;
    public long cant;

    public EntidadYEntero(Entidad entidad) {
        this.entidad = entidad;
        this.cant= 0;
    }



}
