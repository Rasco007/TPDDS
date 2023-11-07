package WebApp;


import Domain.Grupo8.Entity;
import Domain.Grupo8.Incident;
import Domain.Incidente.Incidente;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

        //System.out.println(listaIncidentes);
        List<Map<String, Object>> result = new ArrayList<>();

        for (Incidente incidente :listaIncidentes) {

            Map<String, Object> nuevoJson = new HashMap<>();
            nuevoJson.put("id", incidente.getId());
            nuevoJson.put("observaciones", incidente.getObservaciones());
            nuevoJson.put("hora_de_inicio", incidente.getFecha_hora_de_inicio());
            nuevoJson.put("hora_de_cierre", incidente.getFecha_Hora_de_cierre());
            nuevoJson.put("resuelto", incidente.getResuelto());

            result.add((Map<String, Object>) nuevoJson);

            nuevoJson.put("incidentes", listaIncidentes);
            ctx.render("listadoIncidentes.hbs", nuevoJson);
        }
    }
}
