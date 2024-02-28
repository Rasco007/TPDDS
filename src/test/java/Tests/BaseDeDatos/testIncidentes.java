package Tests.BaseDeDatos;

import Domain.GeoRef.Ubicacion;
import Domain.Incidente.Incidente;
import Domain.Personas.Comunidad;
import Domain.Servicio.Servicio;
import Domain.Servicio.Servicio_Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityTransaction;
import java.sql.SQLException;

import Domain.Entidades.Entidad;
import Domain.Entidades.Establecimiento;
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
import java.util.ArrayList;
import java.util.List;

public class testIncidentes implements WithSimplePersistenceUnit{


    public boolean crear_incidente(){

        /*String query = "SELECT e FROM Incidente e where e.id = 2";
        Query hibernateQuery = entityManager().createQuery(query);
        Incidente incidente = (Incidente) hibernateQuery.getSingleResult();

        Incidente cinemark= new Incidente();
        cinemark.setNombre("Cinemark");
        cinemark.setSucursales(listaEstablecimientos);

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(cinemark);

        tx.commit();
*/
        return true;
    }
    @Test
    public void incidentes() throws SQLException {
        Assertions.assertTrue(crear_incidente());
    }

    public boolean eliminar_incidente(){


        String query = "SELECT e FROM Incidente e where e.id = 5";
        Query hibernateQuery = entityManager().createQuery(query);

        Incidente entidadAEliminar = (Incidente) hibernateQuery.getSingleResult();

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        entityManager().remove(entidadAEliminar);
        tx.commit();

        return true;
    }
    @Test
    public void test_eliminar_incidentes() throws SQLException {
        Assertions.assertTrue(eliminar_incidente());
    }

    @Test
    public void test_editar_incidente() throws SQLException {
        Assertions.assertTrue(editar_incidente());
    }
    public boolean editar_incidente(){
        String query1 = "SELECT e FROM Incidente e where e.id =1";
        Query hibernateQuery1 = entityManager().createQuery(query1);
        Incidente incidenteAEditar = (Incidente) hibernateQuery1.getSingleResult();

        String query = "SELECT e FROM Establecimiento e where e.id =9";
        Query hibernateQuery = entityManager().createQuery(query);
        Establecimiento establecimiento = (Establecimiento) hibernateQuery.getSingleResult();


        String query2 = "SELECT e FROM Comunidad e where e.id =2";
        Query hibernateQuery2 = entityManager().createQuery(query2);
        Comunidad comunidad = (Comunidad) hibernateQuery2.getSingleResult();

        String query3 = "SELECT e FROM Comunidad e where e.id =2";
        Query hibernateQuery3 = entityManager().createQuery(query3);
        Comunidad servicio = (Comunidad) hibernateQuery3.getSingleResult();

        //incidenteAEditar.setServicio_afectado("Molinetes sin funcionar");
        //incidenteAEditar.setEstablecimiento(establecimiento);
        //incidenteAEditar.setComunidad_afectada(comunidad);

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().merge(incidenteAEditar);

        tx.commit();



        return true;
    }



    @Test
    public void test_traer_incidentes() throws SQLException {
        Assertions.assertTrue(traerIncidentes());
    }
    public boolean traerIncidentes(){
        String query1 = "SELECT e FROM Incidente e where e.id =6";
        Query hibernateQuery1 = entityManager().createQuery(query1);
        Incidente incidenteAEditar = (Incidente) hibernateQuery1.getSingleResult();

        System.out.println(incidenteAEditar.getComunidad_afectada().getNombre());
        System.out.println(incidenteAEditar.getEstablecimiento().getNombre());
        System.out.println(incidenteAEditar.getServicio_afectado().getDescripcion());


        return true;
    }
}
