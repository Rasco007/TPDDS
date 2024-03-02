package ar.edu.utn.frba.dds.WebApp;

import java.io.IOException;
import java.util.function.Consumer;

import ar.edu.utn.frba.dds.Domain.Grupo8.RepoEntidad;
import ar.edu.utn.frba.dds.Domain.Grupo8.RepoIncidente;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
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

        //FLUJO DE PAGINA WEB
        app.get("/home", ctx -> ctx.render("home.hbs"));
        app.get("/aperturaIncidentes", new AltaIncidenteController());
        app.get("/cierreIncidentes", ctx -> ctx.render("cierreIncidentes.hbs"));
        app.get("/adminUsuario", new AdminUsuariosController());
        app.get("/listadoIncidentes", new ListaIncidentes());
        app.get("/dropSucursal/{opcion}",ctx -> new AltaIncidenteController().opcionesSucursales(ctx));
        app.get("/dropServicio/{opcion}",ctx -> new AltaIncidenteController().opcionesServicios(ctx));



        app.get("/cargaDeEntidadesOrg", ctx -> ctx.render("cargaDeEntidadesOrg.hbs"));
        app.get("/listaComunidades", new listadoComunidades());
        app.get("/altaComunidades", new altaComunidad());
        app.get("/cierreComunidad", new cierreComunidad());
        app.get("/listaEntidades", new listadoEntidades());
        app.get("/altaEntidades", ctx -> ctx.render("altaEntidades.hbs"));

        app.get("/visualizacionRankings", new RankingsController());



        //ALTA DE INCIDENTES
        app.post("/aperturaIncidentes", ctx -> new AltaIncidenteController().altaIncidente(ctx));
        app.post("/cierreIncidentes", new CierreIncidenteController());
        app.post("/adminUsuario", new AdminUsuariosController());
        app.post("/unirseComunidad", ctx -> new listadoComunidades().unirseComunidad(ctx));
        app.post("/salirComunidad", ctx -> new listadoComunidades().salirComunidad(ctx));
        app.post("/altaComunidades", ctx -> new altaComunidad().alta(ctx));
        app.post("/cierreComunidad", ctx -> new cierreComunidad().eliminarComunidad(ctx));
        app.post("/altaEntidades", ctx -> new altaEntidad().altaEntidad(ctx));
        app.post("/visualizacionRankings", ctx ->  new RankingsController().visualizarRanking(ctx));

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