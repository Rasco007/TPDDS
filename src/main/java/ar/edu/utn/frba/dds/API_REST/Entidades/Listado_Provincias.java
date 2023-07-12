package ar.edu.utn.frba.dds.API_REST.Entidades;

import java.util.List;
import java.util.Optional;

public class Listado_Provincias {
  public int cantidad;
  public int inicio;
  public int total;
  public Parametro parametro;
  public List<Provincia> provincias;

  public Optional<Provincia> provinciaDeId(int id) {
    return this.provincias.stream()
        .filter(p -> p.id == id)
        .findFirst();
  }

  private class Parametro{
    public List<String> campos;
  }
}
