package Domain.GeneradorDeRankings;

import Domain.Incidente.Incidente;

import java.util.List;

public interface Criterio {
    public Ranking generarRanking(List<Incidente> incidentes);
}
