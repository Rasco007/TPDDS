package Domain.GeneradorDeRankings;
import Domain.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Getter
@Setter
public class Generador_Rankings {
    private List<Incidente> incidentesDeLaSemana;

    public Ranking generarRanking(){
        new Mas_Incidentes().generarRanking(incidentesDeLaSemana);
        new Mayor_Grado_Impacto().generarRanking(incidentesDeLaSemana);
        new Mayor_Tiempo_Cierre().generarRanking(incidentesDeLaSemana);
        return null;
    }
}
