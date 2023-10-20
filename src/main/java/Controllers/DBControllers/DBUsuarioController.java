package Controllers.DBControllers;

import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityTransaction;
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



}
