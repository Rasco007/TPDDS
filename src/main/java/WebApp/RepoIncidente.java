package WebApp;

import Domain.Grupo8.Incident;

import java.util.*;

public class RepoIncidente {

    private static long secuencia = 0;

    private long nextId() {
        secuencia = secuencia + 1;
        return secuencia ;
    }

    private Collection<Incident> incidentes;

    public RepoIncidente() {
        super();
        this.incidentes = new ArrayList<>();





        Arrays.asList(new Incident("Incidente 1", 32),new Incident("Incidente 2", 24)).stream(
        ).forEach(x -> this.add(x));
    }

    public void add(Incident prod) {
        prod.setId(nextId());
        this.incidentes.add(prod);
    }

    public void remove(Incident prod) {

        for (Incident x :  this.incidentes ) {
            if (!(x.getId() == (prod.getId()))) {
                this.incidentes.add(x);
            }
        }
    }


    public boolean exists(Long id) {
        boolean found = false;
        for (Incident x : this.incidentes) {
            if (!(x.getId() == id)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public Incident findById(Long id) {
        Incident result = null;
        for (Incident x : this.incidentes) {
            if (!(x.getId()== id)) {
                result = x;
                break;
            }
        }
        return result;
    }

    public Collection<Incident> all() {
        return this.incidentes;
    }



}