package WebApp;


import Controllers.DBControllers.ComunidadController;
import Controllers.DBControllers.EntidadController;
import Domain.Entidades.Entidad;
import Domain.Grupo8.Entity;
import Domain.Grupo8.Incident;
import Domain.Incidente.Incidente;
import Domain.Personas.Comunidad;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.*;

public class altaComunidad implements Handler, WithSimplePersistenceUnit {

    public altaComunidad() {
        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {
        List<Map<String, Object>> result = new EntidadController().listarEntidades(ctx);


        Map<String, Object> context = new HashMap<>();
        context.put("opcionesEntidades", result);
        ctx.render("altaComunidades.hbs", context);
    }


    public void alta(Context ctx) throws Exception {
        String nombreComunidad = ctx.formParam("nombreComunidad");
        int idEntidad = (int) Long.parseLong(Objects.requireNonNull(ctx.formParam("dropdown")));
        String descripComunidad = ctx.formParam("descripComunidad");

        Entidad entidad= entityManager().find(Entidad.class,idEntidad);
        HttpStatus codigoRespuesta = ctx.status();

        Usuario usuarioActual = ctx.sessionAttribute("usuario");
        int usuarioId = usuarioActual.getId();
        Usuario usuarioDB= entityManager().find(Usuario.class,usuarioId);


        try {

                Comunidad nuevaComunidad= new Comunidad();
                nuevaComunidad.setNombre(nombreComunidad);
                nuevaComunidad.setEntidad(entidad);
                nuevaComunidad.setDescripcion(descripComunidad);
                nuevaComunidad.setAdmin(usuarioDB);
                nuevaComunidad.setMiembro(usuarioDB);

                usuarioDB.setComunidad(nuevaComunidad);
                entidad.setComunidad(nuevaComunidad);

                EntityTransaction tx = entityManager().getTransaction();
                tx.begin();
                entityManager().persist(nuevaComunidad);
                entityManager().merge(usuarioDB);
                entityManager().merge(entidad);

                tx.commit();

                if(codigoRespuesta == HttpStatus.OK){

                    List<Map<String, Object>> result = new EntidadController().listarEntidades(ctx);


                    Map<String, Object> context = new HashMap<>();
                    context.put("opcionesEntidades", result);
                    context.put("exitoMensaje", "Comunidad creada correctamente");
                    ctx.render("altaComunidades.hbs", context);

                }else{

                    Map<String, Object> context = new HashMap<>();
                    context.put("exitoMensaje", "NO se ha podido crear la Comunidad");
                    ctx.render("altaComunidades.hbs", context);

                }


        }
        catch (PersistenceException e) {

            Map<String, Object> context = new HashMap<>();
            context.put("exitoMensaje", "Ha habido un error");
            ctx.render("altaComunidades.hbs", context);

        } catch (Exception e) {
            Map<String, Object> context = new HashMap<>();
            context.put("exitoMensaje", "Ha habido un error inesperado");
            ctx.render("altaComunidades.hbs", context);
        }



    }
}
