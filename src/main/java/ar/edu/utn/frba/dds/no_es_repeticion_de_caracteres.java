package ar.edu.utn.frba.dds;

public class no_es_repeticion_de_caracteres {
  public boolean validar(String password) {
    char[] stringACaracteres = password.toCharArray();

    for(int i = 0; i < password.length() - 2; i++) {
      if(password.charAt(i) == stringACaracteres[i+1] && stringACaracteres[i+1] == stringACaracteres[i+2]) {
        return false;
      }
    }

    return true;
  }
}
