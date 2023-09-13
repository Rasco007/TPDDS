package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;

import java.util.ArrayList;
import java.util.List;

public class Mapeo {

    public List<Entidad> mapearEntidades(List<EntidadYEntero> listaOriginal){

        List<Entidad> entidades = new ArrayList<Entidad>();

        for(int i = 0;i<listaOriginal.size();i++) {
            entidades.add(listaOriginal.get(i).getEntidad());
        }
        return entidades;
    }

    public Mapeo() {
    }
}
