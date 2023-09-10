package ar.edu.utn.frba.dds.validador;

public class no_es_igual_al_nombre extends validacion {
  String nombre;

  public boolean validar(String password){
    return !password.toUpperCase().contains(nombre.toUpperCase());
  }

  private void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
