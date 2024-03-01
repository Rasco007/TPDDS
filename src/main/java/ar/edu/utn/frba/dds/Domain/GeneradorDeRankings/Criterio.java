package ar.edu.utn.frba.dds.Domain.GeneradorDeRankings;

import ar.edu.utn.frba.dds.Domain.Incidente.Incidente;

import java.util.List;

public interface Criterio {
    public Ranking generarRanking(List<Incidente> incidentes);
}
