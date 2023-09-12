package ar.edu.utn.frba.dds.GeneradorDeRankings;

import ar.edu.utn.frba.dds.Entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
