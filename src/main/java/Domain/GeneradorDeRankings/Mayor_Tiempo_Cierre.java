package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;
import Domain.Incidente.Incidente;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class Mayor_Tiempo_Cierre {

    private List<Entidad_Y_Entero> listaADevolver;

    private void contarDias(Entidad entidad, long tiempoDeCierre) {

        List<Entidad> aux = new Mapeo().mapearEntidades(listaADevolver);

        if (!aux.contains(entidad)){
            this.listaADevolver.add(new Entidad_Y_Entero(entidad));
        }

        for (int i=0; i<this.listaADevolver.size();i++){
            if (entidad == this.listaADevolver.get(i).getEntidad()){
                this.listaADevolver.get(i).cant+=tiempoDeCierre;
                break;
            }
        }


    }

    public Mayor_Tiempo_Cierre() {
        this.listaADevolver=null;
    }

    public void generarRanking(List<Incidente> incidentes) {
        long tiempoDeCierre;
        for (int i=0;i<incidentes.size();i++){
            tiempoDeCierre=incidentes.get(i).getFecha_Hora_de_cierre().getTime()-incidentes.get(i).getFecha_hora_de_inicio().getTime();
            this.contarDias(incidentes.get(i).getServicio_afectado().getEstablecimiento().getEntidad(),tiempoDeCierre);
        }


        //Collections.sort(this.listaADevolver,(a, b)-> {a.getCant() < b.getCant()});
        listaADevolver = new SortEntidades().sortEntidadYentero(listaADevolver);

        for(int i=0;i<listaADevolver.size();i++){
            listaADevolver.get(i).getEntidad().setRankingTiempoDeCierre(
                    new Ranking(LocalDate.now(),1,"Tiempo De Cierre"));
        }
    }
}
