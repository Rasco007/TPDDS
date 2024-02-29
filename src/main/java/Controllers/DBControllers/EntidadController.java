package Controllers.DBControllers;


import Domain.Entidades.Entidad;
import Domain.Personas.Comunidad;
import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.*;

import Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;

public class EntidadController implements WithSimplePersistenceUnit {

    public List<Map<String, Object>> listarEntidades(Context ctx) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();


        Usuario usuarioActual = ctx.sessionAttribute("usuario");
        int usuarioId = usuarioActual.getId();
        Usuario usuarioDB = entityManager().find(Usuario.class, usuarioId);


        String query = "SELECT e FROM Entidad e";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Entidad> listadoEntidades = hibernateQuery.getResultList();

        for (Entidad entidad : listadoEntidades) {
            Map<String, Object> nuevoJson = new HashMap<>();
            nuevoJson.put("valor", entidad.getNombre());
            nuevoJson.put("valorId", entidad.getId());
            result.add( nuevoJson);
        }

        return result;
    }
}