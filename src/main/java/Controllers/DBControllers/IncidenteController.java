package Controllers.DBControllers;

import Domain.Entidades.Entidad;
import Domain.Personas.Comunidad;
import Domain.Personas.Usuario;
import Domain.Servicio.Servicio;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncidenteController implements WithSimplePersistenceUnit {

    public List<Map<String, Object>> listarComunidades(Context ctx) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();


        Usuario usuarioActual = ctx.sessionAttribute("usuario");
        int usuarioId = usuarioActual.getId();
        Usuario usuarioDB= entityManager().find(Usuario.class,usuarioId);


        String query = "SELECT e FROM Comunidad e";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Comunidad> listadoComunidades = hibernateQuery.getResultList();

        //System.out.println(listadoComunidades);

        for (Comunidad comunidad :listadoComunidades) {

            if (comunidad.estaElMiembro(usuarioDB)) {

                Map<String, Object> nuevoJson = new HashMap<>();
                nuevoJson.put("valorComu", comunidad.getNombre());
                nuevoJson.put("valorIdComu", comunidad.getId());

                result.add( nuevoJson);
            }

        }

        return result;
    }


    public List<Map<String, Object>> listarServicios(Context ctx) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();


        Usuario usuarioActual = ctx.sessionAttribute("usuario");
        int usuarioId = usuarioActual.getId();
        Usuario usuarioDB= entityManager().find(Usuario.class,usuarioId);


        String query = "SELECT e FROM Servicio e";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Servicio> listadoServicios = hibernateQuery.getResultList();

        //System.out.println(listadoComunidades);

        for (Servicio servicio :listadoServicios) {

                Map<String, Object> nuevoJson = new HashMap<>();
                nuevoJson.put("valorServicio", servicio.getDescripcion());
                nuevoJson.put("valorIdServicio", servicio.getId());

                result.add( nuevoJson);

        }

        return result;
    }

}
