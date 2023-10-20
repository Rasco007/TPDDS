package WebApp;

import Domain.Entidades.*;
import Domain.Grupo8.*;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;

import java.util .*;

//@RestController
//@RequestMapping(value = "/api")
public class ApiRankings implements Handler {

    private RepoEntidad repo;

    public ApiRankings(RepoEntidad repo) {
        super();
        this.repo = repo;
    }

    @Override
    public void handle( Context ctx) throws Exception {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> jsonGral = new HashMap<>();
        double coeficiente = 1.5; // Valor hardcodeado

        for (Entity entity : repo.all()) {
            int tResolucionSum = 0;
            int incidentesNoResueltos = 0;
            int miembrosAfectados = entity.getMiembrosAfectados();

            for (Incident incident : entity.getIncidentes()) {
                if (incident.isResuelto()) {
                    tResolucionSum += incident.getTiempoResolucion();
                } else {
                    incidentesNoResueltos++;
                }
            }

            double nuevoValor = (tResolucionSum + (incidentesNoResueltos * coeficiente)) * miembrosAfectados;

// Crear una nueva estructura de datos
            Map<String, Object> nuevoJson = new HashMap<>();
            nuevoJson.put("id", entity.getId());
            nuevoJson.put("nombre", entity.getNombre());
            nuevoJson.put("nuevoValor", nuevoValor);

            result.add(nuevoJson);

            nuevoJson.put("rankings", result);
            ctx.render("visualizacionRankings.hbs", nuevoJson);
        }

        // Ordenar la lista de resultado por nuevoValor en orden ascendente
        result.sort(Comparator.comparingDouble(o -> (Double) o.get("nuevoValor")));

    }



}