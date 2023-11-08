package WebApp;

import java.io.IOException;
import java.util.function.Consumer;

import Domain.Grupo8.Incident;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import io.javalin.rendering.JavalinRenderer;

public class WebApp {

    public static void main(String[] args) {

        initTemplateEngine();

        RepoEntidad repo = new RepoEntidad();

        RepoIncidente repoIncidente = new RepoIncidente();

        Integer port = Integer.parseInt(System.getProperty("port", "8080"));
        Javalin app = Javalin.create(config()).start(port);
        //INICIO
        app.get("/", ctx -> ctx.render("index.hbs"));

        //API GRUPO 18
        app.get("/visualizacionRankings", (Handler) new ApiRankings(repo));

        //FLUJO DE PAGINA WEB
        app.get("/home", ctx -> ctx.render("home.hbs"));
        app.get("/aperturaIncidentes", ctx -> ctx.render("aperturaIncidentes.hbs"));
        app.get("/cierreIncidentes", ctx -> ctx.render("cierreIncidentes.hbs"));
        app.get("/adminUsuario", new AdminUsuariosController());
        app.get("/listadoIncidentes", new ListaIncidentes());

        app.get("/cargaDeEntidadesOrg", ctx -> ctx.render("cargaDeEntidadesOrg.hbs"));


        //ALTA DE INCIDENTES
        app.post("/aperturaIncidentes", new AltaIncidenteController());
        app.post("/cierreIncidentes", new CierreIncidenteController());
        app.post("/home", new LoginController());


        //API NUESTRA
        //app.post("/api/productos", new AltaProductoController(repo));
        //app.get("/api/productos", new ListaProductoController(repo));

        //app.delete("/api/productos/{prodId}", new BajaProductoController(repo));

        //app.get("/productos/{prodId}", new UIProductoController(repo));
        //app.get("/productos", new UIListaProductosController(repo));
        //app.post("/productos", new UIAltaProductoController(repo));

    }

    private static void initTemplateEngine() {

        JavalinRenderer.register(
                (path, model, context) -> { // Función que renderiza el template
                    Handlebars handlebars = new Handlebars();
                    Template template = null;
                    try {
                        template = handlebars.compile("templates/" + path.replace(".hbs", ""));
                        return template.apply(model);
                    } catch (IOException e) {
                        //
                        e.printStackTrace();
                        context.status(HttpStatus.NOT_FOUND);
                        return "No se encuentra la página indicada...";
                    }
                }, ".hbs" // Extensión del archivo de template
        );

    }

    private static Consumer<JavalinConfig> config() {
        return config -> {
            config.staticFiles.add(staticFiles -> {
                staticFiles.hostedPath = "/";
                staticFiles.directory = "/public";
            });
        };
    }

}