package ar.edu.utn.frba.dds.GeneradorDeRankings;

import ar.edu.utn.frba.dds.Incidente.Incidente;

        ;
import java.util.List;
import java.util.stream.Collectors;

public class MasIncidentes {
    private List<EntidadYEntero> listaADevolver;
    public Ranking generar(List<Incidente> incidentes){

        incidentes.forEach(incidente -> {this.contarEntidades(incidente.getServicioAfectado().getEstablecimiento().getEntidad());});


    }

    private void contarEntidades(final Domain.entidades.Entidad entidad){

        List<Domain.entidades.Entidad> aux = this.listaADevolver.stream().map().collect(Collectors.toList());
        if (aux.contains(entidad)){
           this.listaADevolver.forEach(elemento -> {if((elemento.getEntidad())==entidad){elemento.cant++};});
        }else{
            this.listaADevolver.add(new EntidadYEntero(entidad));
        }
    }
}

