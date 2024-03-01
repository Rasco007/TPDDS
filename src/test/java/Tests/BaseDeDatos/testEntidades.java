package Tests.BaseDeDatos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityTransaction;
import java.sql.SQLException;

import ar.edu.utn.frba.dds.Domain.Entidades.Entidad;
import ar.edu.utn.frba.dds.Domain.Entidades.Establecimiento;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.Query;
import java.util.List;

public class testEntidades implements WithSimplePersistenceUnit{


    public boolean crear_entidad(){

        String query = "SELECT e FROM Establecimiento e where e.id = 11 or e.id = 12";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Establecimiento> listaEstablecimientos = hibernateQuery.getResultList();

        Entidad cinemark= new Entidad();
        cinemark.setNombre("Cinemark");
        cinemark.setSucursales(listaEstablecimientos);

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(cinemark);

        tx.commit();

        return true;
    }
    @Test
    public void entidades() throws SQLException {
        Assertions.assertTrue(crear_entidad());
    }

    public boolean eliminar_entidad(){


        String query = "SELECT e FROM Entidad e where e.id = 5";
        Query hibernateQuery = entityManager().createQuery(query);

        Entidad entidadAEliminar = (Entidad) hibernateQuery.getSingleResult();

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        entityManager().remove(entidadAEliminar);
        tx.commit();

        return true;
    }
    @Test
    public void test_eliminar_entidades() throws SQLException {
        Assertions.assertTrue(eliminar_entidad());
    }

    @Test
    public void test_editar_entidad() throws SQLException {
        Assertions.assertTrue(editar_entidad());
    }
    public boolean editar_entidad(){
        String query1 = "SELECT e FROM Entidad e where e.id =1";
        Query hibernateQuery1 = entityManager().createQuery(query1);
        Entidad entidadAEditar = (Entidad) hibernateQuery1.getSingleResult();
       /* String query = "SELECT e FROM Establecimiento e where e.id = 6 or e.id = 7 or e.id = 8";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Establecimiento> listaEstablecimientos = hibernateQuery.getResultList();



        entidadAEditar.setSucursales(listaEstablecimientos);

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().merge(entidadAEditar);

        tx.commit();*/
        System.out.println(entidadAEditar.getSucursales());


        return true;
    }


}
