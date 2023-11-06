package WebApp;

import java.util.*;
import Domain.Grupo8.Incident;

import Domain.Incidente.Incidente;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;


import javax.persistence.EntityTransaction;

public class AltaIncidenteController implements Handler, WithSimplePersistenceUnit {

    private RepoIncidente repo;

    public AltaIncidenteController(RepoIncidente repo) {
        super();
        this.repo = repo;
    }

    @Override
    public void handle(Context ctx) throws Exception {

        /*String tiempoResolucionStr = ctx.formParam("tiempoResolucion");
        Integer tiempoResolucion = Integer.parseInt(tiempoResolucionStr);

        Incident prod = new Incident(ctx.formParam("descripcion"),
                tiempoResolucion) ;
        this.repo.add(prod);*/

        Incidente incidente=new Incidente();
        //incidente.setServicio_afectado(1);
        incidente.setObservaciones(ctx.formParam("descripcion"));



        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(incidente);

        tx.commit();



        //ctx.redirect("/productos"); -- COMENTADO
        //ctx.render("aperturaIncidentes.hbs", "Agregado");

        //ctx.result("Agregado");
        ctx.redirect("/aperturaIncidentes");


    }

}
