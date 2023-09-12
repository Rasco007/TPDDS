package Domain.GeoRef.Entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Localidad {
    public int id;
    public String nombre;
    public Centroide centroide;
}
