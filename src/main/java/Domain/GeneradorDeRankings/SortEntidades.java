package Domain.GeneradorDeRankings;

import Domain.Entidades.Entidad;

import java.util.ArrayList;
import java.util.List;

public class SortEntidades {
    public SortEntidades() {
    }

    public List<Entidad_Y_Entero> sortEntidadYentero(List<Entidad_Y_Entero> listaOriginal){
        List<Entidad_Y_Entero> listaAEntregar=new ArrayList<Entidad_Y_Entero>();
        List<Entidad_Y_Entero> aux=listaOriginal;
        int max=0;
        while(aux.size()>0){
            for(int i=0;i<aux.size();i++){
                if(aux.get(i).cant>aux.get(max).cant){max=i;}
            }
            listaAEntregar.add(aux.get(max));
            aux.remove(max);
        }


        return listaAEntregar;
    }
}
