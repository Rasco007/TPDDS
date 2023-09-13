package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class Ranking {
    private Timestamp semana; //marca el dia en el que se hizo el ranking, Posiblemente el ultimo dia de la semana
    private List<Entidad> listaOrdenadaDeEntidades;
    private String tipoDeRanking;

    public Ranking(Timestamp semana, List<Entidad> listaOrdenadaDeEntidades, String tipoDeRanking) {
        this.semana = semana;
        this.listaOrdenadaDeEntidades = listaOrdenadaDeEntidades;
        this.tipoDeRanking = tipoDeRanking;
    }
}
