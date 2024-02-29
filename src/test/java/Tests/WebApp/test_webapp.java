package Tests.WebApp;


import Domain.Grupo8.Entity;
import Domain.Grupo8.Incident;
import WebApp.RankingsController;
import Domain.Grupo8.RepoEntidad;
import io.javalin.Javalin;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class test_webapp {

    private Javalin app;



    @Test
    public void main() throws IOException {

        RepoEntidad repo = new RepoEntidad();

        Incident incidente1 = new Incident("baño se rompe", 20);
        Incident incidente2 = new Incident("La escalera mecánica está rota", 30);
        Incident incidente3 = new Incident("Se rompió el mostrador", 15);

        List<Incident> ListaIncidentes1 = new ArrayList<>();
        ListaIncidentes1.add(incidente1);
        ListaIncidentes1.add(incidente2);

        List<Incident> ListaIncidentes2 = new ArrayList<>();
        ListaIncidentes2.add(incidente3);

        Entity entidad1 = new Entity("Entidad 1", 10, ListaIncidentes1);
        Entity entidad2 =new Entity("Entidad 2", 15, ListaIncidentes2);

        //RankingsController api = new RankingsController(repo);

        //System.out.println(api);

    }
    }


