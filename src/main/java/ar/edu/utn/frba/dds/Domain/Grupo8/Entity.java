package ar.edu.utn.frba.dds.Domain.Grupo8;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@NoArgsConstructor
@Setter
public class Entity implements Serializable {
    private long id;
    private String nombre;
    private Integer miembrosAfectados;
    private List<Incident> incidentes;

    public Entity(String nombre, Integer miembrosAfectados, List<Incident> incidentes) {
        this.nombre = nombre;
        this.miembrosAfectados = miembrosAfectados;
        this.incidentes = incidentes;
    }


}
