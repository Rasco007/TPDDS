package WebApp;

import java.util.*;
import Domain.Grupo8.Incident;

import Domain.Incidente.Incidente;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;


import javax.persistence.EntityTransaction;

public class AltaIncidenteController implements Handler, WithSimplePersistenceUnit {


    public AltaIncidenteController() {
        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {


        Incidente incidente=new Incidente();
        //incidente.setServicio_afectado(1); //TODO - agregar un servicio
        incidente.setObservaciones(ctx.formParam("descripcion"));


        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(incidente);

        tx.commit();

        HttpStatus codigoRespuesta = ctx.status();

        if(codigoRespuesta == HttpStatus.OK){
            ctx.render("aperturaIncidentes.hbs", Map.of("exitoMensaje", "El incidente se ha creado exitosamente."));

        }else{
            ctx.render("aperturaIncidentes.hbs", Map.of("errorMensaje", "El incidente NO se ha podido crear."));

        }





    }

}
