package Domain.validador;

public class no_es_igual_al_nombre extends validacion {
  private String nombre;

  public no_es_igual_al_nombre(String nombre){
    this.nombre = nombre;
  }

  public boolean validar(String password){
    return !password.toUpperCase().contains(nombre.toUpperCase());
  }
}