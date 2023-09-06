package ar.edu.utn.frba.dds.GeneradorDeRankings;
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

}
