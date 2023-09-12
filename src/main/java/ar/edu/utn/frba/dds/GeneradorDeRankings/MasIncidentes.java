package ar.edu.utn.frba.dds.GeneradorDeRankings;

import ar.edu.utn.frba.dds.Entidades.Entidad;
import ar.edu.utn.frba.dds.Incidente.Incidente;

        ;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MasIncidentes {
    private List<EntidadYEntero> listaADevolver;
    public Ranking generarRanking(List<Incidente> incidentes){


        for (int i=0;i<incidentes.size();i++){
            this.contarEntidades(incidentes.get(i).getServicioAfectado().getEstablecimiento().getEntidad());
        }

        Collections.sort(this.listaADevolver,(a,b)-> {a.getCant() < b.getCant()});

        return new Ranking(new Timestamp(System.currentTimeMillis()), new Mapeo().mapearEntidades(listaADevolver),"Mas incidentes");
    }

    private void contarEntidades(Entidad entidad){

        List<Entidad> aux = new Mapeo().mapearEntidades(this.listaADevolver);

        if (!aux.contains(entidad)){
            this.listaADevolver.add(new EntidadYEntero(entidad));
        }

        for (int i=0; i<this.listaADevolver.size();i++){
            if (entidad == this.listaADevolver.get(i).getEntidad()){
                this.listaADevolver.get(i).cant++;
                break;
            }
        }

    }

    public MasIncidentes() {
        this.listaADevolver=null;
    }
}

