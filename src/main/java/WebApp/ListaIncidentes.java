package WebApp;


import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
public class ListaIncidentes implements Handler {

    private RepoIncidente repo;

    public ListaIncidentes(RepoIncidente repo) {
        super();
        this.repo = repo;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.json(repo.all());
    }
}
