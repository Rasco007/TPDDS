package ar.edu.utn.frba.dds.WebApp;


import ar.edu.utn.frba.dds.DBControllers.EntidadController;
import ar.edu.utn.frba.dds.Domain.Entidades.Entidad;
import ar.edu.utn.frba.dds.Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.*;

public class altaEntidad implements Handler, WithSimplePersistenceUnit {

    public altaEntidad() {
        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {

    }


    public void altaEntidad(Context ctx) throws Exception {
        String nombreEntidad = ctx.formParam("nombreEntidad");

        HttpStatus codigoRespuesta = ctx.status();

        Usuario usuarioActual = ctx.sessionAttribute("usuario");
        int usuarioId = usuarioActual.getId();
        Usuario usuarioDB= entityManager().find(Usuario.class,usuarioId);


        try {

            Entidad nuevaEntidad= new Entidad();
            nuevaEntidad.setNombre(nombreEntidad);
            nuevaEntidad.setUsuario_creador(usuarioDB);
            usuarioDB.setEntidad(nuevaEntidad);
            EntityTransaction tx = entityManager().getTransaction();
            tx.begin();
            entityManager().persist(nuevaEntidad);
            entityManager().merge(usuarioDB);

            tx.commit();

            if(codigoRespuesta == HttpStatus.OK){

                List<Map<String, Object>> result = new EntidadController().listarEntidades(ctx);


                Map<String, Object> context = new HashMap<>();
                context.put("opcionesEntidades", result);
                context.put("exitoMensaje", "Entidad creada correctamente");
                ctx.render("altaEntidades.hbs", context);

            }else{

                Map<String, Object> context = new HashMap<>();
                context.put("exitoMensaje", "NO se ha podido crear la Entidad");
                ctx.render("altaEntidades.hbs", context);

            }


        }
        catch (PersistenceException e) {

            Map<String, Object> context = new HashMap<>();
            context.put("exitoMensaje", "Ha habido un error");
            ctx.render("altaEntidades.hbs", context);

        } catch (Exception e) {
            Map<String, Object> context = new HashMap<>();
            context.put("exitoMensaje", "Ha habido un error inesperado");
            ctx.render("altaEntidades.hbs", context);
        }



    }
}
