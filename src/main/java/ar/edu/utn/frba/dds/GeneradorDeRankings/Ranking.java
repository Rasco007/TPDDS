package ar.edu.utn.frba.dds.GeneradorDeRankings;
import Domain.entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class Ranking {
    private Timestamp semana; //marca el primer dia de la semana en cuestion?
    private List<Domain.entidades.Entidad> listaOrdenadaDeEntidades;
    private String tipoDeRanking;

    public Ranking(Timestamp semana, List<Entidad> listaOrdenadaDeEntidades, String tipoDeRanking) {
        this.semana = semana;
        this.listaOrdenadaDeEntidades = listaOrdenadaDeEntidades;
        this.tipoDeRanking = tipoDeRanking;
    }
}
