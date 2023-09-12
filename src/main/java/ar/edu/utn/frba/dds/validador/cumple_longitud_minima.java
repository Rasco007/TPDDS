package ar.edu.utn.frba.dds.validador;

public class cumple_longitud_minima extends validacion {
  int MIN = 8;

  public boolean validar(String password){
    return password.length() >= MIN;
  }
}
