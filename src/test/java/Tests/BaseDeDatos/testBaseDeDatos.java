package Tests.BaseDeDatos;

import Domain.Entidades.Entidad;
import Domain.Entidades.Entidad_Prestadora;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testBaseDeDatos implements WithSimplePersistenceUnit {

    private boolean agregarEntidad() throws SQLException {
        Usuario usuario=new Usuario();
        usuario.setLogin("boca");
        usuario.setPassword("riverPlate1234");

        Entidad entidad= new Entidad();
       //entidad.setNombre("LineaB");
       // entidad.setReceptor_informacion_designado(usuario);
        Entidad_Prestadora entidad_prestadora=new Entidad_Prestadora();
        entidad_prestadora.setNombre("Metrovias");
        List<Entidad> entidades=new ArrayList<Entidad>();
        entidades.add(entidad);
        entidad_prestadora.setEntidades(entidades);
        List<Entidad_Prestadora> prestadoras=new ArrayList<Entidad_Prestadora>();
        prestadoras.add(entidad_prestadora);
       // entidad.setPrestadoras(prestadoras);

        //String jdbcUrl = "jdbc:mysql://your-mysql-server:3306/your-database?serverTimezone=America/Argentina/Buenos_Aires";
        //Connection connection = DriverManager.getConnection(jdbcUrl, "root", "1234");


        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(usuario);
        entityManager().persist(entidad);
       // entityManager().persist(entidad_prestadora);
        tx.commit();
        return true;

    }

    @Test
    public void testearBaseDeDatos() throws SQLException {
        Assertions.assertEquals(true,agregarEntidad());
    };

}
