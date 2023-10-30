package WebApp;

import Domain.Grupo8.Incident;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

import java.util.Objects;

public class CierreIncidenteController implements Handler{

    private RepoIncidente repo;

    public CierreIncidenteController(RepoIncidente repo) {
        super();
        this.repo = repo;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        Long prodID = Long.parseLong(Objects.requireNonNull(ctx.formParam("id_incidente")));

        if (repo.exists(prodID)) {
            Incident prod = repo.findById(prodID);
            this.repo.remove(prod);
            ctx.redirect("/cierreIncidentes");

        } else {
            ctx.status(HttpStatus.NOT_FOUND);
            ctx.result("Producto no encontrado");
        }


    }
}
