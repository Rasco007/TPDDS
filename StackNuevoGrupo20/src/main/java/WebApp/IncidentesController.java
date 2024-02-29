package WebApp;


import Domain.Incidente.Incidente;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncidentesController implements  WithSimplePersistenceUnit {

    @Autowired
    private EntityManager entityManager;

    public  List<Incidente> buscarTodos() {


        String query = "SELECT e FROM Incidente e";
        Query hibernateQuery = entityManager().createQuery(query);
        List<Incidente> listaIncidentes = hibernateQuery.getResultList();

       return listaIncidentes;
    }
}
