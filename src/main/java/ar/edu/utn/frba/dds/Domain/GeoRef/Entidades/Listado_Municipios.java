package ar.edu.utn.frba.dds.Domain.GeoRef.Entidades;

import java.util.List;

public class Listado_Municipios {
  public int cantidad;
  public int total;
  public int inicio;
  public Parametro parametros;
  public List<Municipio> municipios;

  private class Parametro {
    public List<String> campos;
    public int max;
    public List<String> provincia;
  }
}