package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Ranking {
    @Id
    @GeneratedValue
    private int id;
    @Column //TODO agregar al DER
    private Timestamp semana; //marca el dia en el que se hizo el ranking, Posiblemente el ultimo dia de la semana
    //TODO aca tmp se como solucionarlo
     // tiene q venir ordenada, y no se como va a buscar a las entidades despues
    // :)))
    private List<Entidad> listaOrdenadaDeEntidades;
    @Column(columnDefinition = "varchar2(100)")
    private String tipoDeRanking;

    public Ranking(Timestamp semana, List<Entidad> listaOrdenadaDeEntidades, String tipoDeRanking) {
        this.semana = semana;
        this.listaOrdenadaDeEntidades = listaOrdenadaDeEntidades;
        this.tipoDeRanking = tipoDeRanking;
    }
}

