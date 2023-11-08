package WebApp;

import Controllers.DBControllers.DBUsuarioController;
import Domain.Incidente.Incidente;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUsuariosController implements Handler, WithSimplePersistenceUnit {

    public  AdminUsuariosController(){

        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {
        int id = ctx.sessionAttribute("id");
        String metodo = String.valueOf(ctx.method());
        if(metodo== "GET"){
            traerUsuario( id,  ctx);
        } else if (metodo == "POST") {
            int rta= new DBUsuarioController().modificarUsuario(id,ctx.formParam("login"), ctx.formParam("pass"));
            if (rta !=-1){

                traerUsuario( id,  ctx);

                ctx.render("adminUsuario.hbs", Map.of("exitoMensaje", "Se modificó el Usuario"));

            }else {
                ctx.render("adminUsuario.hbs", Map.of("errorMensaje", "NO se ha podido modificar el usuario."));

            }


        }



    }

    public void traerUsuario(int id, Context ctx){
        String query = "SELECT u FROM Usuario u Where id = :x";
        List<Usuario>  usuarios = (List<Usuario>) entityManager().createQuery(query).setParameter("x",id).getResultList();

        List<Map<String, Object>> result = new ArrayList<>();

        for (Usuario usuario :usuarios) {

            Map<String, Object> nuevoJson = new HashMap<>();
            nuevoJson.put("login", usuario.getLogin());
            nuevoJson.put("pass", usuario.getPassword());


            result.add((Map<String, Object>) nuevoJson);

            nuevoJson.put("usuarios", usuarios);
            ctx.render("adminUsuario.hbs", nuevoJson);
        }
    }
}
