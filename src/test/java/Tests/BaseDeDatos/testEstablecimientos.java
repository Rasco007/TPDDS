package Tests.BaseDeDatos;

import Domain.GeoRef.Ubicacion;
import Domain.Incidente.Incidente;
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

public class testEstablecimientos implements WithSimplePersistenceUnit{


    public boolean crear_establecimiento(){

        String query = "SELECT e FROM Servicio e where e.id = 262144 or e.id = 131072 or e.id = 163840 or e.id = 229376";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Servicio> listaServicios = hibernateQuery.getResultList();

    Establecimiento cinemarkBoedo= new Establecimiento();
        cinemarkBoedo.setNombre("Cinemark Boedo");
        cinemarkBoedo.setUbicacion(new Ubicacion(43534543.0, 61724746.0));
        cinemarkBoedo.setServicios(listaServicios);

    EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
    entityManager().persist(cinemarkBoedo);

        tx.commit();

        return true;
}
    @Test
    public void establecimientos() throws SQLException {
        Assertions.assertTrue(crear_establecimiento());
    }


    @Test
    public void test_editar_establecimiento() throws SQLException {
        Assertions.assertTrue(editar_establecimiento());
    }
    public boolean editar_establecimiento(){

        String query = "SELECT e FROM Establecimiento e where e.id = 12";
        Query hibernateQuery = entityManager().createQuery(query);
        Establecimiento establecimiento = (Establecimiento) hibernateQuery.getSingleResult();

        String query1 = "SELECT e FROM Entidad e where e.id =4";
        Query hibernateQuery1 = entityManager().createQuery(query1);
        Entidad entidadAEditar = (Entidad) hibernateQuery1.getSingleResult();

        establecimiento.setEntidad(entidadAEditar);

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().merge(establecimiento);

        tx.commit();

        return true;
    }

}
