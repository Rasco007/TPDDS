package ar.edu.utn.frba.dds.GeneradorDeRankings;
import ar.edu.utn.frba.dds.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class GeneradorDeRankings {
    private List<Incidente> incidentesDeLaSemana;

    public Ranking generarRanking(){
        new MasIncidentes().generarRanking(incidentesDeLaSemana);
        new MayorGradoDeImpacto().generarRanking(incidentesDeLaSemana);
        new MayorTiempoDeCierre().generarRanking(incidentesDeLaSemana);
        return null;
    }
}
