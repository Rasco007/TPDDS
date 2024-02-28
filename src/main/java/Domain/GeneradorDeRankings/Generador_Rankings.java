package Domain.GeneradorDeRankings;
import Domain.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Generador_Rankings {


    @Id
    @GeneratedValue
    private int id;
    @Column
    private LocalDate semanaActual;
    @OneToMany(mappedBy = "generadorSemanal")
    private List<Incidente> incidentesDeLaSemana;

    public Ranking generarRanking(){
        new Mas_Incidentes().generarRanking(incidentesDeLaSemana);
        //new Mayor_Grado_Impacto().generarRanking(incidentesDeLaSemana);
        //new Mayor_Tiempo_Cierre().generarRanking(incidentesDeLaSemana);
        return null;
    }

    public Generador_Rankings() {
        semanaActual=LocalDate.now();
    }
}
