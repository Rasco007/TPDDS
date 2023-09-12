package ar.edu.utn.frba.dds.GeneradorDeRankings;

import java.util.ArrayList;
import java.util.List;

public class Mapeo {
    public Mapeo() {
    }

    public List<Domain.entidades.Entidad> mapearEntidades(List<EntidadYEntero> listaOriginal){

        List<Domain.entidades.Entidad> entidades = new ArrayList<Domain.entidades.Entidad>();

        for(int i = 0;i<listaOriginal.size();i++) {
            entidades.add(listaOriginal.get(i).getEntidad());
        }
        return entidades;
    }
}
