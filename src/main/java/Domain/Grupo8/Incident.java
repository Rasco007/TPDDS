package Domain.Grupo8;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Incident implements Serializable {
    private long id;

    private String descripcion;

    private Integer tiempoResolucion;

    private Boolean resuelto;



    public boolean isResuelto() {
        return resuelto;
    }

    public Incident(String descripcion, Integer tiempoResolucion) {
        this.descripcion = descripcion;
        this.tiempoResolucion = tiempoResolucion;
        this.resuelto = false;
    }
}