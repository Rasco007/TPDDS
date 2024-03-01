package ar.edu.utn.frba.dds.Domain.Grupo8;

import java.util.*;

public class RepoEntidad {

    private static long secuencia = 0;

    private long nextId() {
        secuencia = secuencia + 1;
        return secuencia ;
    }

    private Collection<Entity> entidades;

    public RepoEntidad() {
        super();
        this.entidades = new ArrayList<>();

        Incident incidente1 = new Incident("baño se rompe", 20);
        Incident incidente2 = new Incident("La escalera mecánica está rota", 30);
        Incident incidente3 = new Incident("Se rompió el mostrador", 15);
        List<Incident> ListaIncidentes1 = new ArrayList<>();
        ListaIncidentes1.add(incidente1);
        ListaIncidentes1.add(incidente2);

        List<Incident> ListaIncidentes2 = new ArrayList<>();
        ListaIncidentes2.add(incidente3);



        Arrays.asList(new Entity("Entidad 1", 10, ListaIncidentes1),new Entity("Entidad 2", 15, ListaIncidentes2)).stream(
        ).forEach(x -> this.add(x));
    }

    public void add(Entity prod) {
        prod.setId(nextId());
        this.entidades.add(prod);
    }

    public void remove(Entity prod) {

        for (Entity x :  this.entidades ) {

            if ((x.getId() == (prod.getId()))) {
                this.entidades.add(x);
            }
        }
    }


    public boolean exists(Long id) {
        boolean found = false;
        for (Entity x : this.entidades) {
            if (!(x.getId() == id)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public Entity findById(Long id) {
        Entity result = null;
        for (Entity x : this.entidades) {
            if (!(x.getId()== id)) {
                result = x;
                break;
            }
        }
        return result;
    }

    public Collection<Entity> all() {
        return this.entidades;
    }



}