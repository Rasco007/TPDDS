package Tests.BaseDeDatos;

import Controllers.DBControllers.DBUsuarioController;
import Domain.Entidades.Entidad;
import Domain.Entidades.Entidad_Prestadora;
import Domain.Personas.Perfil;
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
        usuario.setLogin("carlos");
        usuario.setPassword("saul");

        Entidad entidad= new Entidad();
        entidad.setNombre("LineaB");
        entidad.setReceptor_informacion_designado(usuario);
        Entidad_Prestadora entidad_prestadora=new Entidad_Prestadora();
        entidad_prestadora.setNombre("Metrovias");
        List<Entidad> entidades=new ArrayList<Entidad>();
        entidades.add(entidad);
        entidad_prestadora.setEntidades(entidades);
        List<Entidad_Prestadora> prestadoras=new ArrayList<Entidad_Prestadora>();
        prestadoras.add(entidad_prestadora);
        entidad.setPrestadoras(prestadoras);




        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(usuario);
        entityManager().persist(entidad);
        entityManager().persist(entidad_prestadora);
        tx.commit();
        return true;

    }

    public int validarInicioDeSecion(String login, String pass){
        String qery ="SELECT u FROM Usuario u Where u.login = :x";
        Usuario usuario = (Usuario) entityManager().createQuery(qery).setParameter("x",login).getSingleResult();
        //Usuario usuario = (Usuario) entityManager().createQuery(qery, Usuario.class).setParameter("x",login).getSingleResult();

      if (usuario.getPassword().equals(pass)){
          return usuario.getId();
      }
      return -1;
    }

    public boolean recuperarUsuarioPorId(){
        Usuario usuario= entityManager().find(Usuario.class,1);
        /*System.out.print("%");
        System.out.print(usuario.getLogin());
        System.out.print("%");
        System.out.print("\n");
        System.out.print(usuario.getPassword());
        System.out.print("\n");
        System.out.print(usuario.getId());
        System.out.print("\n");*/
        if(usuario.getLogin().equals("boca")){
            return true;
        }
        return false;
    }

    @Test
    public void recuperarPorId() throws SQLException{
        Assertions.assertTrue(recuperarUsuarioPorId());
    }

    @Test
    public void testearBaseDeDatos() throws SQLException {
        Assertions.assertEquals(true,agregarEntidad());
    };



    @Test
    public void testearLoginConBase() throws SQLException{
        Assertions.assertEquals(3,validarInicioDeSecion("Roberto","25/5ALGO"));
    }


    private boolean eliminarUs(int id){
        new DBUsuarioController().eliminarUsuario(id);
        return true;
    }

    @Test
    public void eliminarUsDeBase() throws SQLException{
        Assertions.assertTrue(eliminarUs(1));
    }


    private boolean cambioUsuario(){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

            Usuario usuario=entityManager().find(Usuario.class,4);
            Perfil perfil= new Perfil();
            perfil.setApellido("Perez");
            perfil.setNombre("Checo");
            perfil.setCorreo("checoPerez@RB.com");
            perfil.setPuntosDeConfianza(3);
            perfil.setTelefono("11-6589-8475");
            usuario.setPerfil(perfil);
            entityManager().persist(perfil);
        tx.commit();
        return true;
    }
    @Test
    public void cambio() throws SQLException{
        Assertions.assertTrue(cambioUsuario());
    }




}
