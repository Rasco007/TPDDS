package ar.edu.utn.frba.dds.WebApp;

import ar.edu.utn.frba.dds.DBControllers.IncidenteController;
import ar.edu.utn.frba.dds.Domain.Grupo8.*;
import ar.edu.utn.frba.dds.Domain.Incidente.Incidente;
import ar.edu.utn.frba.dds.Domain.Personas.Comunidad;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import org.springframework.web.bind.annotation.*;

import java.util .*;

@RestController
@RequestMapping(value = "/api")

public class RankingsController implements Handler, WithSimplePersistenceUnit {


    public RankingsController() {
        super();
    }

    @Override
    public void handle( Context ctx) throws Exception {

        List<Map<String, Object>> result = new IncidenteController().listarComunidades(ctx);

        Map<String, Object> context = new HashMap<>();
        context.put("opcionesComunidades", result);
        ctx.render("visualizacionRankings.hbs", context);


        /*


        //ARRANCO CON LOS INCIDENTES
        String query = "SELECT e FROM Incidente e";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Incidente> listaIncidentes = hibernateQuery.getResultList();

            for (Incidente incidente : listaIncidentes) {
                Map<String, Object> nuevoJson = new HashMap<>();
                int tResolucionSum = 0;
                int incidentesNoResueltos = 0;

                if (incidente.getResuelto()) {
                    tResolucionSum += incidente.getTiempo_de_resolucion();
                } else {
                    incidentesNoResueltos++;
                }
                nuevoJson.put("id", incidente.getId());
                nuevoJson.put("descripcion", incidente.getObservaciones());
                double nuevoValor = (tResolucionSum + (incidentesNoResueltos * coeficiente)); //* miembrosAfectados;
                nuevoJson.put("nuevoValor", nuevoValor);
                result.add(nuevoJson);

            }

        Map<String, Object> context = new HashMap<>();
        context.put("rankings", result);
        ctx.render("visualizacionRankings.hbs", context);
        //}

        // Ordenar la lista de resultado por nuevoValor en orden ascendente
        result.sort(Comparator.comparingDouble(o -> (Double) o.get("nuevoValor")));

        */

    }

    public void visualizarRanking( Context ctx) throws Exception {
        int com_id = (int) Long.parseLong(Objects.requireNonNull(ctx.formParam("dropdown")));

        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> jsonGral = new HashMap<>();
        double coeficiente = 1.5; // Valor hardcodeado

        //ARRANCO CON LOS INCIDENTES
        Comunidad comunidad= entityManager().find(Comunidad.class,com_id);
        List<Incidente> listaIncidentes =  comunidad.getListado_incidentes();


        for (Incidente incidente : listaIncidentes) {
            Map<String, Object> nuevoJson = new HashMap<>();
            int tResolucionSum = 0;
            int incidentesNoResueltos = 0;

            if (incidente.getResuelto()) {
                long diferenciaEnMinutos = (incidente.getFecha_hora_de_cierre().getTime() - incidente.getFecha_hora_de_inicio().getTime())/60000;

                tResolucionSum += diferenciaEnMinutos;
            } else {
                incidentesNoResueltos++;
            }
            nuevoJson.put("id", incidente.getId());
            nuevoJson.put("descripcion", incidente.getObservaciones());
            double nuevoValor = (tResolucionSum + (incidentesNoResueltos * coeficiente)); //* miembrosAfectados;
            nuevoJson.put("nuevoValor", nuevoValor);
            result.add(nuevoJson);

        }
        result.sort(Comparator.comparingDouble(o -> (Double) o.get("nuevoValor")));
        Collections.reverse(result);

        List<Map<String, Object>> resultComus = new IncidenteController().listarComunidades(ctx);

        Map<String, Object> context = new HashMap<>();
        context.put("rankings", result);
        context.put("opcionesComunidades", resultComus);

        ctx.render("visualizacionRankings.hbs", context);



    }


}