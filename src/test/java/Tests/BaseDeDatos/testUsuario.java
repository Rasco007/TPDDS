package Tests.BaseDeDatos;

import Domain.Entidades.Entidad;
import Domain.Entidades.Establecimiento;
import Domain.Incidente.Incidente;
import Domain.Personas.Comunidad;
import Domain.Personas.Usuario;
import Domain.Servicio.Estados.Activo;
import Domain.Servicio.Servicio;
import Domain.Servicio.Servicio_Base;
import Domain.Servicio.Servicio_Compuesto;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.SQLException;

public class testUsuario implements WithSimplePersistenceUnit {

    public boolean crear_usuario(){



        Usuario carlos= new Usuario();
        carlos.setLogin("carlos");
        carlos.setPassword("saul");

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(carlos);

        tx.commit();

        return true;
    }
    @Test
    public void usuario() throws SQLException {
        Assertions.assertTrue(crear_usuario());
    }

    public boolean poner_en_comunidad(){


        String query = "SELECT e FROM Usuario e where e.id = 25";
        Query hibernateQuery = entityManager().createQuery(query);
        Usuario usuarioAEditar = (Usuario) hibernateQuery.getSingleResult();

        String query2 = "SELECT e FROM Comunidad e where e.id =4";
        Query hibernateQuery2 = entityManager().createQuery(query2);
        Comunidad comunidad = (Comunidad) hibernateQuery2.getSingleResult();

        comunidad.setMiembro(usuarioAEditar);
        usuarioAEditar.setComunidad(comunidad);


        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().merge(usuarioAEditar);
        entityManager().merge(comunidad);

        tx.commit();

        return true;
    }
    @Test
    public void test_poner_en_comunidad() throws SQLException {
        Assertions.assertTrue(poner_en_comunidad());
    }



    @Test
    public void test_traer_usuario() throws SQLException {
        Assertions.assertTrue(traerUsuario());
    }
    public boolean traerUsuario(){
        String query1 = "SELECT e FROM Usuario e where e.id =25";
        Query hibernateQuery1 = entityManager().createQuery(query1);
        Usuario usuarioAEditar = (Usuario) hibernateQuery1.getSingleResult();

        String query2 = "SELECT e FROM Comunidad e where e.id =4";
        Query hibernateQuery2 = entityManager().createQuery(query2);
        Comunidad comunidad = (Comunidad) hibernateQuery2.getSingleResult();

        System.out.println(usuarioAEditar.getComunidades());
        System.out.println(comunidad.getMiembros());


        return true;
    }


    public boolean eliminar_usuario(){


        String query = "SELECT e FROM Usuario e where e.id = 26";
        Query hibernateQuery = entityManager().createQuery(query);

        Usuario entidadAEliminar = (Usuario) hibernateQuery.getSingleResult();

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        entityManager().remove(entidadAEliminar);
        tx.commit();

        return true;
    }
    @Test
    public void test_eliminar_usuario() throws SQLException {
        Assertions.assertTrue(eliminar_usuario());
    }

}
