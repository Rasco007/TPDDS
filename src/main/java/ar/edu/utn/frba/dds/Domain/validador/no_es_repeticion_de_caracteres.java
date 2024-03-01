package ar.edu.utn.frba.dds.Domain.validador;

import ar.edu.utn.frba.dds.Domain.Personas.Usuario;

public class no_es_repeticion_de_caracteres extends validacion {
  public boolean validar(Usuario usuario) {
    String password = usuario.getPassword();
    char[] stringACaracteres = password.toCharArray();

    for(int i = 0; i < password.length() - 2; i++) {
      if(password.charAt(i) == stringACaracteres[i+1] && stringACaracteres[i+1] == stringACaracteres[i+2]) {
        return false;
      }
    }

    return true;
  }
}
