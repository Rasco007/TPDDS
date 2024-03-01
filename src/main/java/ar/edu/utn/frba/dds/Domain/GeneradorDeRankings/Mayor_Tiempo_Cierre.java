package ar.edu.utn.frba.dds.Domain.GeneradorDeRankings;

import ar.edu.utn.frba.dds.Domain.Entidades.Entidad;

import java.util.ArrayList;
import java.util.List;

public class Mayor_Tiempo_Cierre {

    private List<Entidad_Y_Entero> listaADevolver;

    private void promediar() {

        List<Entidad> aux = new ArrayList<Entidad>();
        List<Entidad_Y_Entero> listaNueva=new ArrayList<Entidad_Y_Entero>();
        int contador=0;
        int listaNuevalen=0;
        Entidad entidad;
        long promedio;
        for (int i=0; i<this.listaADevolver.size();i++){
            contador=0;
            entidad=listaADevolver.get(i).entidad;
            if (!aux.contains(entidad)){
                listaNueva.add(new Entidad_Y_Entero(entidad)); //en pos listanuevalen
                aux.add(entidad);

                for (int j=0; j<this.listaADevolver.size();j++){
                    if(entidad==listaADevolver.get(j).entidad){

                        listaNueva.get(listaNuevalen).cant+=this.listaADevolver.get(j).cant;
                        contador++;
                    }
                }

                promedio = (listaNueva.get(listaNuevalen).getCant())/contador;
                listaNueva.get(listaNuevalen).setCant(promedio);
                listaNuevalen++;
            }

        }
        this.listaADevolver=listaNueva;

    }

    public Mayor_Tiempo_Cierre() {
        this.listaADevolver=new ArrayList<Entidad_Y_Entero>();
    }

    /*public void generarRanking(List<Incidente> incidentes) {
        long tiempoDeCierre;
        int listaADevolverLen=0;
        for (int i=0;i<incidentes.size();i++) {
            if(incidentes.get(i).getResuelto()){
                tiempoDeCierre = incidentes.get(i).getFecha_hora_de_cierre().getTime() - incidentes.get(i).getFecha_hora_de_inicio().getTime();
                this.listaADevolver.add(new Entidad_Y_Entero(incidentes.get(i).getServicio_afectado().getEstablecimiento().getEntidad()));
                this.listaADevolver.get(listaADevolverLen).setCant(tiempoDeCierre);
                listaADevolverLen++;
            }
        }
        for(int i=0;i<listaADevolver.size();i++){
            System.out.print(listaADevolver.get(i).getEntidad().getNombre());
            System.out.print("\n");
        }
        System.out.print("\n");
        this.promediar();
        for(int i=0;i<listaADevolver.size();i++){
            System.out.print(listaADevolver.get(i).getEntidad().getNombre());
            System.out.print("\n");
        }
        System.out.print("\n");
        //Collections.sort(this.listaADevolver,(a, b)-> {a.getCant() < b.getCant()});
        listaADevolver = new SortEntidades().sortEntidadYentero(listaADevolver);


        for(int i=0;i<listaADevolver.size();i++){
            listaADevolver.get(i).getEntidad().setRankingTiempoDeCierre(new Ranking(LocalDate.now(),i,"Tiempo De Cierre"));
            System.out.print(listaADevolver.get(i).getEntidad().getNombre());System.out.print("\n");
        }
    }*/
}
