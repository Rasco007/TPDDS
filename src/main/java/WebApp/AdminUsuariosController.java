package WebApp;

import Controllers.DBControllers.DBUsuarioController;
import Domain.Incidente.Incidente;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import javax.persistence.Query;
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
        System.out.println(id);

        String query = "SELECT u FROM Usuario u Where id = :x";
        Usuario usuario = (Usuario) entityManager().createQuery(query).setParameter("x",id).getSingleResult();
        System.out.println(usuario.getLogin());
        System.out.println(usuario.getPassword());

        ctx.attribute("usuario", usuario);
        //ctx.attribute("pass", usuario.getPassword());

        ctx.render("adminUsuario.hbs");

    }
}
