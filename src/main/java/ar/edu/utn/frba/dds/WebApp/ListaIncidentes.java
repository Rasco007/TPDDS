package ar.edu.utn.frba.dds.WebApp;


import ar.edu.utn.frba.dds.Domain.Grupo8.RepoIncidente;
import ar.edu.utn.frba.dds.Domain.Incidente.Incidente;
import ar.edu.utn.frba.dds.Domain.Personas.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaIncidentes implements Handler, WithSimplePersistenceUnit {

    private RepoIncidente repo;

    public ListaIncidentes() {
        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {
        //ctx.json(repo.all());


        String query = "SELECT e FROM Incidente e";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Incidente> listaIncidentes = hibernateQuery.getResultList();

        Usuario usuarioActual = ctx.sessionAttribute("usuario");
        int usuarioId = usuarioActual.getId();
        Usuario usuarioDB= entityManager().find(Usuario.class,usuarioId);


        //System.out.println(listaIncidentes);
        List<Map<String, Object>> result = new ArrayList<>();

        for (Incidente incidente :listaIncidentes) {

            if (incidente.getComunidad_afectada().estaElMiembro(usuarioDB)){
                Map<String, Object> nuevoJson = new HashMap<>();
                nuevoJson.put("id", incidente.getId());
                nuevoJson.put("observaciones", incidente.getObservaciones());
                nuevoJson.put("comunidad", incidente.getComunidad_afectada().getNombre());
                nuevoJson.put("establecimiento", incidente.getEstablecimiento().getNombre());

                nuevoJson.put("hora_de_inicio", incidente.getFecha_hora_de_inicio());
                nuevoJson.put("hora_de_cierre", (incidente.getFecha_hora_de_cierre() != null) ?
                        incidente.getFecha_hora_de_cierre() :
                        "");
                nuevoJson.put("resuelto", (!incidente.getResuelto()) ?
                        "NO" :
                        "SI");

                result.add( nuevoJson);

            }



        }
        Map<String, Object> context = new HashMap<>();
        context.put("incidentes", result);
        ctx.render("listadoIncidentes.hbs", context);

    }
}
