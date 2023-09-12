package ar.edu.utn.frba.dds.GeneradorDeRankings;
import ar.edu.utn.frba.dds.Incidente.Incidente;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class MayorGradoDeImpacto {


    private List<EntidadYEntero> listaADevolver;
    public Ranking generarRanking(List<Incidente> incidentes){
        long cantAfectados;

        for (int i=0;i<incidentes.size();i++){
            cantAfectados=incidentes.get(i).getComunidadAfectada().getMiembrosAfectados().size();
            this.contarUsuariosAfectados(incidentes.get(i).getServicioAfectado().getEstablecimiento().getEntidad(),cantAfectados);
        }

        Collections.sort(this.listaADevolver,(a, b)-> {a.getCant() < b.getCant()});

        return new Ranking(new Timestamp(System.currentTimeMillis()), new Mapeo().mapearEntidades(listaADevolver),"Mayor grado de impacto");


    }

    private void contarUsuariosAfectados(Domain.entidades.Entidad entidad, long cantUsuarios){

        List<Domain.entidades.Entidad> aux = new Mapeo().mapearEntidades(listaADevolver);

        if (!aux.contains(entidad)){
            this.listaADevolver.add(new EntidadYEntero(entidad));
        }

        for (int i=0; i<this.listaADevolver.size();i++){
            if (entidad == this.listaADevolver.get(i).getEntidad()){
                this.listaADevolver.get(i).cant+=cantUsuarios;
                break;
            }
        }
    }

    public MayorGradoDeImpacto() {
        this.listaADevolver=null;
    }
}
