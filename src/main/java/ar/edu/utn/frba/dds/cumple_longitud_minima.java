package ar.edu.utn.frba.dds;

public class cumple_longitud_minima {
  int MIN = 8;

  public boolean validar(String password){
    return password.length() >= MIN;
  }
}
