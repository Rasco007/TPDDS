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
import java.util.ArrayList;
import java.util.List;

public class testBaseDeDatos implements WithSimplePersistenceUnit {

    private boolean agregarEntidad(){
        Usuario usuario=new Usuario();
        usuario.setLogin("unUsuario");
        /*Entidad entidad= new Entidad();
        entidad.setNombre("LineaB");
        entidad.setReceptor_informacion_designado(usuario);
        Entidad_Prestadora entidad_prestadora=new Entidad_Prestadora();
        entidad_prestadora.setNombre("Metrovias");
        List<Entidad> entidades=new ArrayList<Entidad>(entidad.getId());
        entidad_prestadora.setEntidades(entidades);*/

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(usuario);
        //entityManager().persist(entidad);
        //entityManager().persist(entidad_prestadora);
        tx.commit();
        return true;

    }

    @Test
    public void testearBaseDeDatos(){
        Assertions.assertEquals(true,agregarEntidad());
    };

}
