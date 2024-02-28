package WebApp;

import Controllers.DBControllers.DBUsuarioController;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class LoginController implements Handler, WithSimplePersistenceUnit {

    public  LoginController(){

        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {
        int id= new DBUsuarioController().validarInicioDeSecion(ctx.formParam("login"), ctx.formParam("pass"));
        Usuario usuarioLogueado = new DBUsuarioController().recuperarUsuarioPorId(id);
        if (id!=-1){

            ctx.sessionAttribute("id",id);
            ctx.sessionAttribute("usuario", usuarioLogueado);

            ctx.redirect("/home");


        }
        else{

            ctx.render("index.hbs", Map.of("errorMensaje", "NO se ha podido inciar sesión."));

        }
    }

}
