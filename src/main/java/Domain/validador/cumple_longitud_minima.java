package Domain.validador;

import Domain.Personas.Usuario;

public class cumple_longitud_minima extends validacion {
  private int MIN = 8;

  public boolean validar(Usuario usuario){
    return usuario.getPassword().length() >= MIN;
  }
}