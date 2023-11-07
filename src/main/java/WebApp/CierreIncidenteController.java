package WebApp;

import Domain.Grupo8.Incident;
import Domain.Incidente.Incidente;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

import javax.persistence.EntityTransaction;
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

        if (incidente != null) {
            EntityTransaction tx = entityManager().getTransaction();
            tx.begin();
            entityManager().remove(incidente);
            tx.commit();
            if(codigoRespuesta == HttpStatus.OK){
                ctx.render("cierreIncidentes.hbs", Map.of("exitoMensaje", "El incidente se ha borrado exitosamente."));

            }else{
                ctx.render("cierreIncidentes.hbs", Map.of("errorMensaje", "El incidente NO se ha podido borrar."));

            }
        } else {
            ctx.render("cierreIncidentes.hbs", Map.of("errorMensaje", "El incidente con el ID proporcionado no existe."));
            // Manejar el caso donde el incidente no existe
        }





    }
}
