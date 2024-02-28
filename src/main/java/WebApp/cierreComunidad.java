package WebApp;


import Controllers.DBControllers.ComunidadController;
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

public class cierreComunidad implements Handler, WithSimplePersistenceUnit {

    public cierreComunidad() {
        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {

        List<Map<String, Object>> result = new ComunidadController().listarComunidadesPropias(ctx);

        Map<String, Object> context = new HashMap<>();
        context.put("comunidades", result);
        ctx.render("cierreComunidad.hbs", context);


    }

    public void eliminarComunidad(Context ctx) throws Exception {
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

                    EntityTransaction tx = entityManager().getTransaction();
                    tx.begin();

                    usuarioDB.removeComunidad(comunidad);

                    entityManager().merge(usuarioDB);
                    entityManager().remove(comunidad);
                    tx.commit();

                    if(codigoRespuesta == HttpStatus.OK){
                        List<Map<String, Object>> result = new ComunidadController().listarComunidadesPropias(ctx);
                        //System.out.println(result);

                        Map<String, Object> context = new HashMap<>();
                        context.put("comunidades", result);
                        context.put("exitoMensaje", "Has eliminado la comunidad correctamente");
                        ctx.render("cierreComunidad.hbs", context);

                    }else{
                        List<Map<String, Object>> result = new ComunidadController().listarComunidadesPropias(ctx);
                        //System.out.println(result);

                        Map<String, Object> context = new HashMap<>();
                        context.put("comunidades", result);
                        context.put("errorMensaje", "NO se ha podido eliminar la comunidad.");
                        ctx.render("cierreComunidad.hbs", context);
                    }



            }else {
                List<Map<String, Object>> result = new ComunidadController().listarComunidadesPropias(ctx);
                //System.out.println(result);

                Map<String, Object> context = new HashMap<>();
                context.put("comunidades", result);
                context.put("errorMensaje", "Ha surgido un error al eliminar la comunidad.");
                ctx.render("cierreComunidad.hbs", context);
            }
        }
        catch (PersistenceException e) {
            List<Map<String, Object>> result = new ComunidadController().listarComunidadesPropias(ctx);
            //System.out.println(result);

            Map<String, Object> context = new HashMap<>();
            context.put("comunidades", result);
            context.put("errorMensaje", "Ha surgido un error en la persistencia.");
            ctx.render("cierreComunidad.hbs", context);

        } catch (Exception e) {
            ctx.render("listaComunidades.hbs", Map.of("errorMensaje", "Error inesperado en la persistencia de datos."));

        }

    }


}
