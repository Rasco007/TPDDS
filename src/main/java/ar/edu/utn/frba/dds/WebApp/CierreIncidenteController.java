package ar.edu.utn.frba.dds.WebApp;

import ar.edu.utn.frba.dds.Domain.Incidente.Incidente;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

import javax.persistence.EntityTransaction;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class CierreIncidenteController implements Handler, WithSimplePersistenceUnit {


    public CierreIncidenteController() {
        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {
        int incId = (int) Long.parseLong(Objects.requireNonNull(ctx.formParam("id_incidente")));

        Incidente incidente= entityManager().find(Incidente.class,incId);
        HttpStatus codigoRespuesta = ctx.status();

        //CALCULO DE FECHAS
        Timestamp nuevaFechaCierre = Timestamp.valueOf(LocalDateTime.now());
        long diferenciaEnSegundos = (nuevaFechaCierre.getTime() - incidente.getFecha_hora_de_inicio().getTime())/60000;


        //EDITAR EL INCIDENTE
        if (incidente != null) {
            if (incidente.getResuelto()){
                ctx.render("cierreIncidentes.hbs", Map.of("errorMensaje", "El incidente ya fue resuelto."));


            }else{
                EntityTransaction tx = entityManager().getTransaction();
                tx.begin();
                incidente.setResuelto(true);
                incidente.setFecha_hora_de_cierre(nuevaFechaCierre);
                incidente.setTiempo_de_resolucion(diferenciaEnSegundos);
                entityManager().merge(incidente);
                tx.commit();
                if(codigoRespuesta == HttpStatus.OK){
                    ctx.render("cierreIncidentes.hbs", Map.of("exitoMensaje", "El incidente se ha cerrado exitosamente."));

                }else{
                    ctx.render("cierreIncidentes.hbs", Map.of("errorMensaje", "El incidente NO se ha podido cerrar."));

                }
            }

        } else {
            ctx.render("cierreIncidentes.hbs", Map.of("errorMensaje", "El incidente con el ID proporcionado no existe."));
            // Manejar el caso donde el incidente no existe
        }





    }
}
