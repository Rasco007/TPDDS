package Domain.validador;

public class cumple_longitud_minima extends validacion {
  private int MIN = 8;

  public boolean validar(String password){
    return password.length() >= MIN;
  }
}
