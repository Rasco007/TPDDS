package ar.edu.utn.frba.dds.GeneradorDeRankings;
import ar.edu.utn.frba.dds.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
public class MayorGradoDeImpacto {


    private List<EntidadYEntero> listaADevolver;
    public Ranking generar(List<Incidente> incidentes){

        incidentes.forEach(incidente -> {incidente.getComunidadAfectada()});


    }

}
