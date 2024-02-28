package Tests.BaseDeDatos;

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
import java.sql.SQLException;

public class testServicios implements WithSimplePersistenceUnit {

    public boolean crear_servicios(){



        Servicio ascensor= new Servicio_Base();
        ascensor.setEstado_servicio(new Activo());
        ascensor.setDescripcion("ascensor");

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(ascensor);

        tx.commit();

        return true;
    }
    @Test
    public void servicios() throws SQLException {
        Assertions.assertTrue(crear_servicios());
    }
}
