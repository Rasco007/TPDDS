package Controllers.DBControllers;

import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
        String qery ="SELECT u FROM Usuario u Where u.login = :x and u.password = :y";
        Usuario usuario = (Usuario) entityManager().createQuery(qery).setParameter("x",login).setParameter("y", pass).getSingleResult();

        if (usuario.getPassword().equals(pass)){
            return usuario.getId();
        }else{
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
