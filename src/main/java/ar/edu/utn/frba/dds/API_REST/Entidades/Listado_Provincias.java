package ar.edu.utn.frba.dds.API_REST.Entidades;

import java.util.List;

public class Listado_Provincias {
  public int cantidad;
  public int inicio;
  public int total;
  public Parametro parametro;
  public List<Provincia> provincias;

  private class Parametro{
    public List<String> campos;
  }
}
