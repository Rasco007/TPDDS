package Tests.BaseDeDatos;
import ar.edu.utn.frba.dds.Domain.Personas.Comunidad;
import ar.edu.utn.frba.dds.Domain.Personas.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityTransaction;
import java.sql.SQLException;

import ar.edu.utn.frba.dds.Domain.Entidades.Entidad;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.Query;
import java.util.List;


public class testComunidades implements WithSimplePersistenceUnit {

    public boolean crear_comunidad(){

        String query = "SELECT e FROM Usuario e where e.id = 24";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Usuario> listaMiembros =  hibernateQuery.getResultList();

        Comunidad fansCinemark= new Comunidad();
        fansCinemark.setNombre("Socios del Ciudad");

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(fansCinemark);

        tx.commit();

        return true;
    }
    @Test
    public void comunidades() throws SQLException {
        Assertions.assertTrue(crear_comunidad());
    }

    public boolean eliminar_comunidad(){


        String query = "SELECT e FROM Comunidad e where e.id =7";
        Query hibernateQuery = entityManager().createQuery(query);

        Comunidad entidadAEliminar = (Comunidad) hibernateQuery.getSingleResult();

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        entityManager().remove(entidadAEliminar);
        tx.commit();

        return true;
    }
    @Test
    public void test_eliminar_comunidades() throws SQLException {
        Assertions.assertTrue(eliminar_comunidad());
    }


    public boolean agregar_descrip(){


        String query = "SELECT e FROM Comunidad e where e.id = 3";
        Query hibernateQuery = entityManager().createQuery(query);

        Comunidad entidadAEliminar = (Comunidad) hibernateQuery.getSingleResult();
        entidadAEliminar.setDescripcion("La mejor comunidad para los fanáticos del Cine Cinemark");
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        entityManager().merge(entidadAEliminar);
        tx.commit();

        return true;
    }
    @Test
    public void test_agregar_descrip() throws SQLException {
        Assertions.assertTrue(agregar_descrip());
    }


    public boolean editar_comunidad(){


        String query = "SELECT e FROM Comunidad e where e.id = 3";
        Query hibernateQuery = entityManager().createQuery(query);
        Comunidad comunidad = (Comunidad) hibernateQuery.getSingleResult();

        String query2 = "SELECT e FROM Entidad e where e.id = 4";
        Query hibernateQuery2 = entityManager().createQuery(query2);

        Entidad entidad = (Entidad) hibernateQuery2.getSingleResult();

        comunidad.setEntidad(entidad);
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        entityManager().merge(comunidad);
        tx.commit();

        return true;
    }
    @Test
    public void test_editar_comunidad() throws SQLException {
        Assertions.assertTrue(editar_comunidad());
    }
}
