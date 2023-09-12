package ar.edu.utn.frba.dds.GeneradorDeRankings;

import ar.edu.utn.frba.dds.Incidente.Incidente;

import java.util.List;

public interface Criterio {
    public Ranking generarRanking(List<Incidente> incidentes);
}
