package ar.edu.utn.frba.dds.Domain.GeoRef.Entidades;

import java.util.List;

public class Listado_Departamentos {
    public int cantidad;
    public int total;
    public Parametro parametros;
    public List<Departamento> departamentos;

    private class Parametro {
        public List<String> campos;
        public int max;
        public List<String> provincia;
    }
}
