package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;
import Domain.Incidente.Incidente;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class Mas_Incidentes {
    private List<Entidad_Y_Entero> listaADevolver;
    public void generarRanking(List<Incidente> incidentes){


        for (int i=0;i<incidentes.size();i++){
            this.contarEntidades(incidentes.get(i).getServicio_afectado().getEstablecimiento().getEntidad());
        }

        //Collections.sort(this.listaADevolver,(a,b)-> {a.getCant() < b.getCant()});
        listaADevolver = new SortEntidades().sortEntidadYentero(listaADevolver);

        for(int i=0;i<listaADevolver.size();i++){
            listaADevolver.get(i).getEntidad().setRankingCantIncidentes(
                    new Ranking(LocalDate.now(),i,"Mas Incidentes"));
        }
    }

    private void contarEntidades(Entidad entidad){

        List<Entidad> aux = new Mapeo().mapearEntidades(this.listaADevolver);

        if (!aux.contains(entidad)){
            this.listaADevolver.add(new Entidad_Y_Entero(entidad));
        }

        for (int i=0; i<this.listaADevolver.size();i++){
            if (entidad == this.listaADevolver.get(i).getEntidad()){
                this.listaADevolver.get(i).cant++;
                break;
            }
        }

    }

    public Mas_Incidentes() {
        this.listaADevolver=null;
    }
}

