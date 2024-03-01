package ar.edu.utn.frba.dds.Domain.GeneradorDeRankings;

import java.util.List;

public class SortEntidades {
    public SortEntidades() {
    }

    public List<Entidad_Y_Entero> sortEntidadYentero(List<Entidad_Y_Entero> listaOriginal){
        Entidad_Y_Entero temp;
        Entidad_Y_Entero temp2;
        int n = listaOriginal.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (listaOriginal.get(i-1).getCant() < listaOriginal.get(i).getCant()) {

                    temp = listaOriginal.get(i-1);
                    //temp2 = listaOriginal.get(i);
                    /*listaOriginal.get(i-1).setEntidad(temp2.getEntidad());
                    listaOriginal.get(i-1).setCant(temp2.getCant());
                    listaOriginal.get(i).setEntidad(temp.getEntidad());
                    listaOriginal.get(i).setCant(temp.getCant());*/
                    listaOriginal.set(i-1,listaOriginal.get(i));
                    listaOriginal.set(i,temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);


        return listaOriginal;
    }
}
