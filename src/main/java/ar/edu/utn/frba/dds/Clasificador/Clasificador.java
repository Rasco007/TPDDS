package ar.edu.utn.frba.dds.Clasificador;

import ar.edu.utn.frba.dds.Comunidad.Comunidad;
import ar.edu.utn.frba.dds.Incidente.Incidente;
import ar.edu.utn.frba.dds.Servicios.Servicio;
import ar.edu.utn.frba.dds.Usuario.Usuario;

import java.util.List;

public class Clasificador {

    public void clasificar(Usuario usuario){

        List<Incidente> incidentesAbiertos = usuario.getPerfil().getIncidentesAbiertos();
        for (int i=0; i<incidentesAbiertos.size();i++){
            if (esAperturaFraudulenta(incidentesAbiertos.get(i))){
                usuario.getPerfil().cambiarConfianza((float) -0.2);
            }
        }

        List<Incidente> incidentesCerrados = usuario.getPerfil().getIncidentesCerrados();
        for (int i=0; i<incidentesCerrados.size();i++){
            if (esCierreFraudulento(incidentesCerrados.get(i))){
                usuario.getPerfil().cambiarConfianza((float) -0.2);
            }
        }

        

    }

    private Boolean esCierreFraudulento(Incidente incidente){
        Servicio servicioAfectado = incidente.getServicioAfectado();

        for (int i=0; i<servicioAfectado.getIncidentes().size();i++){
            if (sonSimilares(incidente,servicioAfectado.getIncidentes().get(i))){
                return true;
            }
        }
        return false;
    }
    private boolean sonSimilares(Incidente incidente1, Incidente incidente2){

        return (incidente1.getComunidadAfectada()==incidente2.getComunidadAfectada() && menosDe3Minutos(incidente1,incidente2));

    }
    private boolean menosDe3Minutos(Incidente incidente1, Incidente incidente2) {
        long tiempoDeSolucion = incidente2.getFechaYHoraDeInicio().getTime()-incidente1.getFechaYHoraDeCierre().getTime();
        return tiempoDeSolucion<180000;//180000 milisegundos son 3 minutos
    }


    private Boolean esAperturaFraudulenta(Incidente incidente){

        long tiempoDeSolucion = incidente.getFechaYHoraDeCierre().getTime()-incidente.getFechaYHoraDeInicio().getTime();
        return tiempoDeSolucion<180000;//180000 milisegundos son 3 minutos

    }


}


