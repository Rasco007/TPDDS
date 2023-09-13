package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;
import Domain.Incidente.Incidente;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

public class MayorTiempoDeCierre {

    private List<EntidadYEntero> listaADevolver;

    private void contarDias(Entidad entidad, long tiempoDeCierre) {

        List<Entidad> aux = new Mapeo().mapearEntidades(listaADevolver);

        if (!aux.contains(entidad)){
            this.listaADevolver.add(new EntidadYEntero(entidad));
        }

        for (int i=0; i<this.listaADevolver.size();i++){
            if (entidad == this.listaADevolver.get(i).getEntidad()){
                this.listaADevolver.get(i).cant+=tiempoDeCierre;
                break;
            }
        }


    }

    public MayorTiempoDeCierre() {
        this.listaADevolver=null;
    }

    public Ranking generarRanking(List<Incidente> incidentes) {
        long tiempoDeCierre;
        for (int i=0;i<incidentes.size();i++){
            tiempoDeCierre=incidentes.get(i).getFechaYHoraDeCierre().getTime()-incidentes.get(i).getFechaYHoraDeInicio().getTime();
            this.contarDias(incidentes.get(i).getServicioAfectado().getEstablecimiento().getEntidad(),tiempoDeCierre);
        }


        Collections.sort(this.listaADevolver,(a, b)-> {a.getCant() < b.getCant()});

        return new Ranking(new Timestamp(System.currentTimeMillis()), new Mapeo().mapearEntidades(listaADevolver),"Mayor tiempo de cierre");
    }
}
