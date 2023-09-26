package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
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
    private LocalDate semana; //marca el dia en el que se hizo el ranking, Posiblemente el ultimo dia de la semana

    @Column
    private int posicion;
    @Column(columnDefinition = "varchar2(100)")
    private String tipoDeRanking;

    public Ranking(LocalDate semana, int posicion, String tipoDeRanking) {
        this.semana = semana;
        this.posicion = posicion;
        this.tipoDeRanking = tipoDeRanking;
    }

    public Ranking() {

    }
}

