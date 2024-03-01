package ar.edu.utn.frba.dds.Domain.GeoRef.Entidades;

import java.util.List;

public class Listado_Localidades {
    public int cantidad;
    public int total;
    public Parametro parametros;
    public List<Localidad> departamentos;

    private class Parametro {
        public List<String> campos;
        public int max;
        public List<String> provincia;
    }
}
