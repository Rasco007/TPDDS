package Domain.GeneradorDeRankings;
import Domain.Entidades.Entidad;
import Domain.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Mayor_Grado_Impacto {


    private List<Entidad_Y_Entero> listaADevolver;
    public void generarRanking(List<Incidente> incidentes){
        long cantAfectados;

        for (int i=0;i<incidentes.size();i++){
            cantAfectados=incidentes.get(i).getComunidad_afectada().getMiembros_afectados().size();
            this.contarUsuariosAfectados(incidentes.get(i).getServicio_afectado().getEstablecimiento().getEntidad(),cantAfectados);
        }

        //Collections.sort(this.listaADevolver,(a, b)-> {a.getCant() < b.getCant()});
        listaADevolver = new SortEntidades().sortEntidadYentero(listaADevolver);
        for(int i=0;i<listaADevolver.size();i++){
            listaADevolver.get(i).getEntidad().setRankingImpacto(
                    new Ranking(LocalDate.now(),i,"Grado De Imparcto"));
        }


    }

    private void contarUsuariosAfectados(Entidad entidad, long cantUsuarios){

        List<Entidad> aux = new Mapeo().mapearEntidades(listaADevolver);

        if (!aux.contains(entidad)){
            this.listaADevolver.add(new Entidad_Y_Entero(entidad));
        }

        for (int i=0; i<this.listaADevolver.size();i++){
            if (entidad == this.listaADevolver.get(i).getEntidad()){
                this.listaADevolver.get(i).cant+=cantUsuarios;
                break;
            }
        }
    }

    public Mayor_Grado_Impacto() {
        this.listaADevolver=null;
    }
}
