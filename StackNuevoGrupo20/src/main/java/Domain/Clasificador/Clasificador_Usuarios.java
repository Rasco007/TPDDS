package Domain.Clasificador;/*package Domain.Clasificador;

import Domain.Incidente.Incidente;
import Domain.Servicios.Servicio;
import Domain.Usuario.Usuario;

import java.util.List;

public class ClasificadorDeUsuarios {

    public void clasificarUsuario(Usuario usuario){

        boolean hizoUnBuenIncidente=false;

        List<Incidente> incidentesAbiertos = usuario.getPerfil().getIncidentesAbiertos();
        for (int i=0; i<incidentesAbiertos.size();i++){
            if (esAperturaFraudulenta(incidentesAbiertos.get(i))){
                usuario.getPerfil().cambiarConfianza((float) -0.2);
            }else if(!hizoUnBuenIncidente){
                hizoUnBuenIncidente=true;
                usuario.getPerfil().cambiarConfianza((float) 0.5);
            }
        }

        List<Incidente> incidentesCerrados = usuario.getPerfil().getIncidentesCerrados();
        for (int i=0; i<incidentesCerrados.size();i++){
            if (esCierreFraudulento(incidentesCerrados.get(i))){
                usuario.getPerfil().cambiarConfianza((float) -0.2);
            }else if(!hizoUnBuenIncidente){
                hizoUnBuenIncidente=true;
                usuario.getPerfil().cambiarConfianza((float) 0.5);
            }
        }

        usuario.getPerfil().setIncidentesAbiertos(null);
        usuario.getPerfil().setIncidentesCerrados(null);


    }

    public ClasificadorDeUsuarios() {
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
    private Boolean esAperturaFraudulenta(Incidente incidente){

        long tiempoDeSolucion = incidente.getFechaYHoraDeCierre().getTime()-incidente.getFechaYHoraDeInicio().getTime();
        return tiempoDeSolucion<180000;//180000 milisegundos son 3 minutos

    }



    private boolean sonSimilares(Incidente incidente1, Incidente incidente2){

        return (incidente1.getComunidadAfectada()==incidente2.getComunidadAfectada() && menosDe3Minutos(incidente1,incidente2));

    }
    private boolean menosDe3Minutos(Incidente incidente1, Incidente incidente2) {
        long tiempoDeSolucion = incidente2.getFechaYHoraDeInicio().getTime()-incidente1.getFechaYHoraDeCierre().getTime();
        return tiempoDeSolucion<180000;//180000 milisegundos son 3 minutos
    }



}
*/