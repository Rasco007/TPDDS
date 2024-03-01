package ar.edu.utn.frba.dds.DBControllers;

import ar.edu.utn.frba.dds.Domain.Personas.Comunidad;
import ar.edu.utn.frba.dds.Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;

import javax.persistence.Query;
import java.util.*;

import java.util.List;

public class ComunidadController implements WithSimplePersistenceUnit {

        public List<Map<String, Object>> listarComunidades(Context ctx){
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();


            Usuario usuarioActual = ctx.sessionAttribute("usuario");
            int usuarioId = usuarioActual.getId();
            Usuario usuarioDB= entityManager().find(Usuario.class,usuarioId);


            String query = "SELECT e FROM Comunidad e";
            Query hibernateQuery = entityManager().createQuery(query);
            List<Comunidad> listadoComunidades = hibernateQuery.getResultList();

            //System.out.println(listadoComunidades);

            for (Comunidad comunidad :listadoComunidades) {

                Map<String, Object> nuevoJson = new HashMap<>();
                nuevoJson.put("id", comunidad.getId());
                nuevoJson.put("nombre", comunidad.getNombre());
                nuevoJson.put("descripcion", comunidad.getDescripcion());

                nuevoJson.put("unido", (!comunidad.estaElMiembro(usuarioDB)) ?
                                        "<button style=\"font-size: 12px;\" class=\"btn btn-primary btn-lg btn-block btn-unir\" type=\"submit\">Unirme</button>" :
                                        "<input name = \"salir\" value=\"salir\" type=\"hidden\"/> <button style=\"font-size: 12px;\" class=\"btn btn-danger btn-lg btn-block btn-unir\"  type=\"submit\">Salir</button>");
                result.add( nuevoJson);


            }

            return result;
        }

    public List<Map<String, Object>> listarComunidadesPropias(Context ctx){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();


        Usuario usuarioActual = ctx.sessionAttribute("usuario");
        int usuarioId = usuarioActual.getId();
        Usuario usuarioDB= entityManager().find(Usuario.class,usuarioId);


        String query = "SELECT e FROM Comunidad e";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Comunidad> listadoComunidades = hibernateQuery.getResultList();

        //System.out.println(listadoComunidades);

        for (Comunidad comunidad :listadoComunidades) {

            if(comunidad.estaElAdmin(usuarioDB)){
                Map<String, Object> nuevoJson = new HashMap<>();
                nuevoJson.put("id", comunidad.getId());
                nuevoJson.put("nombre", comunidad.getNombre());
                nuevoJson.put("descripcion", comunidad.getDescripcion());

                nuevoJson.put("unido",
                        "<button style=\"font-size: 12px;\" class=\"btn btn-warning btn-lg btn-block\" type=\"submit\">Eliminar</button>" );
                result.add( nuevoJson);
            }
        }
        return result;
    }



    }


