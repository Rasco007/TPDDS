package ar.edu.utn.frba.dds;

public class no_es_igual_al_nombre{
  String nombre;

  public no_es_igual_al_nombre(String nombre){
    this.nombre = nombre;
  }

  public boolean validar(String password){
    return !password.toUpperCase().contains(nombre.toUpperCase());
  }
}
