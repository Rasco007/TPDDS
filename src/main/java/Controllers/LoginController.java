package Controllers;
import Domain.Personas.Usuario;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class LoginController implements Handler{


    @Override
    public void handle(@NotNull Context context) throws Exception {
        //aca consume lo q viene del cliente, el login y pass q intenta usar
       // Integer id = validarInicioDeSecion(login,pass);
       // if (id!=-1) {
       //    ctx.sessionAtribute("IdUsuario", id);
       //     ctx.result("Logeado");
       // }else{
       //     ctx.ressult("pass o ligin incorrectos");
       // }
    }

    //public int validarInicioDeSecion(String login, String pass){
      //  Usuario usuario = (Usuario) entityManager().createQuery("from usuario where nombre = :nombre").setParameter("nombre", login).getSingleResult();
      //  if (usuario.getPassword()==pass){
      //      return usuario.getId();
      //  }
      //  return -1;
   // }


}
