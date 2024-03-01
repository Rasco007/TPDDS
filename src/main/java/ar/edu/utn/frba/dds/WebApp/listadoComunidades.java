package ar.edu.utn.frba.dds.WebApp;


import ar.edu.utn.frba.dds.DBControllers.ComunidadController;
import ar.edu.utn.frba.dds.Domain.Personas.Comunidad;
import ar.edu.utn.frba.dds.Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.*;

public class listadoComunidades implements Handler, WithSimplePersistenceUnit {

    public listadoComunidades() {
        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {

        List<Map<String, Object>> result = new ComunidadController().listarComunidades(ctx);

        Map<String, Object> context = new HashMap<>();
        context.put("comunidades", result);
        ctx.render("listaComunidades.hbs", context);


    }

    public void unirseComunidad(Context ctx) throws Exception {
        int comid = (int) Long.parseLong(Objects.requireNonNull(ctx.formParam("id_comunidad")));
        String accion = ctx.formParam("salir");

        Comunidad comunidad= entityManager().find(Comunidad.class,comid);
        HttpStatus codigoRespuesta = ctx.status();

        Usuario usuarioActual = ctx.sessionAttribute("usuario");
        int usuarioId = usuarioActual.getId();
        Usuario usuarioDB= entityManager().find(Usuario.class,usuarioId);

        //System.out.println(usuarioActual.getLogin());

        try {

            if (comunidad != null) {
                if(Objects.equals(accion, "salir")){

                    EntityTransaction tx = entityManager().getTransaction();
                    tx.begin();
                    comunidad.removeMiembro(usuarioDB);
                    usuarioDB.removeComunidad(comunidad);


                    /*String query = "SELECT u FROM Comunidad_miembro u ";
                    Query consulta = entityManager().createQuery(query);

                    Comunidad_miembro comunidad_asignada = (Comunidad_miembro) consulta.getSingleResult();
                    System.out.println(comunidad_asignada);*/


                    entityManager().merge(usuarioDB);
                    entityManager().merge(comunidad);
                    tx.commit();

                    if(codigoRespuesta == HttpStatus.OK){
                        List<Map<String, Object>> result = new ComunidadController().listarComunidades(ctx);
                        //System.out.println(result);

                        Map<String, Object> context = new HashMap<>();
                        context.put("comunidades", result);
                        context.put("exitoMensaje", "Te has salido correctamente.");
                        ctx.render("listaComunidades.hbs", context);

                    }else{
                        List<Map<String, Object>> result = new ComunidadController().listarComunidades(ctx);

                        Map<String, Object> context = new HashMap<>();
                        ctx.render("listaComunidades.hbs");
                        context.put("comunidades", result);
                        ctx.render("listaComunidades.hbs", context);
                        ctx.render("listaComunidades.hbs", Map.of("errorMensaje", "NO has podido salir."));

                    }


                }else{

                    comunidad.setMiembro(usuarioDB);
                    usuarioDB.setComunidad(comunidad);


                    EntityTransaction tx = entityManager().getTransaction();
                    tx.begin();
                    entityManager().merge(comunidad);
                    entityManager().merge(usuarioDB);
                    tx.commit();

                    if(codigoRespuesta == HttpStatus.OK){
                        List<Map<String, Object>> result = new ComunidadController().listarComunidades(ctx);
                        System.out.println(result);

                        Map<String, Object> context = new HashMap<>();
                        context.put("comunidades", result);
                        context.put("exitoMensaje", "Te has unido correctamente.");
                        ctx.render("listaComunidades.hbs", context);

                    }else{
                        List<Map<String, Object>> result = new ComunidadController().listarComunidades(ctx);

                        Map<String, Object> context = new HashMap<>();
                        ctx.render("listaComunidades.hbs");
                        context.put("comunidades", result);
                        ctx.render("listaComunidades.hbs", context);
                        ctx.render("listaComunidades.hbs", Map.of("errorMensaje", "NO te has podido unir."));

                    }
                }
            }else {
                List<Map<String, Object>> result = new ComunidadController().listarComunidades(ctx);

                Map<String, Object> context = new HashMap<>();
                ctx.render("listaComunidades.hbs");
                context.put("comunidades", result);
                ctx.render("listaComunidades.hbs", context);
                ctx.render("listaComunidades.hbs", Map.of("errorMensaje", "Esta comunidad no existe más."));
                // Manejar el caso donde el incidente no existe
            }
        }
        catch (PersistenceException e) {
            List<Map<String, Object>> result = new ComunidadController().listarComunidades(ctx);

            Map<String, Object> context = new HashMap<>();
            ctx.render("listaComunidades.hbs");
            context.put("comunidades", result);
            ctx.render("listaComunidades.hbs", context);
            ctx.render("listaComunidades.hbs", Map.of("errorMensaje", "Error en la persistencia de datos."));

        } catch (Exception e) {
            ctx.render("listaComunidades.hbs", Map.of("errorMensaje", "Error inesperado en la persistencia de datos."));

        }

    }


    }
