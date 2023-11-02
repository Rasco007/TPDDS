package WebApp;

import java.util.*;
import Domain.Grupo8.Incident;

import io.javalin.http.Context;
import io.javalin.http.Handler;
public class AltaIncidenteController implements Handler {

    private RepoIncidente repo;

    public AltaIncidenteController(RepoIncidente repo) {
        super();
        this.repo = repo;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String tiempoResolucionStr = ctx.formParam("tiempoResolucion");
        Integer tiempoResolucion = Integer.parseInt(tiempoResolucionStr);

        Incident prod = new Incident(ctx.formParam("descripcion"),
                tiempoResolucion) ;
        this.repo.add(prod);

        //ctx.redirect("/productos"); -- COMENTADO
        //ctx.render("aperturaIncidentes.hbs", "Agregado");

        //ctx.result("Agregado");
        ctx.redirect("/aperturaIncidentes");


    }

}
