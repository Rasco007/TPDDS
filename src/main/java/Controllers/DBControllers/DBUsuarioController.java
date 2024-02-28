package Controllers.DBControllers;

import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;

public class DBUsuarioController implements WithSimplePersistenceUnit {

    public Usuario recuperarUsuarioPorId(int id){
        Usuario usuario= entityManager().find(Usuario.class,id);
        return usuario;
    }

    public boolean darAltaUsuario(Usuario usuario){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(usuario);
        tx.commit();
        return true;
    }

    public boolean darAtlaUsuarioMultiples(@NotNull List<Usuario> usuarios){
        for(int i=0;i<usuarios.size();i++){
            EntityTransaction tx = entityManager().getTransaction();
            tx.begin();
            entityManager().persist(usuarios.get(i));
            tx.commit();
        }
        return true;
    }

    public void eliminarUsuario(int id) {
        Usuario usuario= entityManager().find(Usuario.class,id);
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().remove(usuario);
        tx.commit();
    }


    public int validarInicioDeSecion(String login, String pass){
        try {
            String query = "SELECT u FROM Usuario u WHERE u.login = :x AND u.password = :y";
            Query consulta = entityManager().createQuery(query)
                    .setParameter("x", login)
                    .setParameter("y", pass);
            Usuario usuario = (Usuario) consulta.getSingleResult();

            if (usuario.getPassword().equals(pass)) {
                return usuario.getId();
            } else {
                return -1;
            }
        } catch (NoResultException e) {
            // Manejar el caso cuando no se encuentra ningún resultado
            return -1;
        }
    }

    public int modificarUsuario(int id, String nuevoNombre, String pass){


        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        Usuario usuario = entityManager().find(Usuario.class, id);
        if (usuario != null) {
            usuario.setLogin(nuevoNombre);
            usuario.setPassword(pass);
            entityManager().persist(usuario);
            tx.commit();
            return 1;
        } else {
            return -1;
        }
    }

}
