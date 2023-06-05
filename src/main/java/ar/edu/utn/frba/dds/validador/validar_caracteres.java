package ar.edu.utn.frba.dds.validador;

public class validar_caracteres extends validacion{
  public boolean validar(String password){
    boolean mayuscula = false;
    boolean minuscula = false;
    boolean digito = false;
    boolean caracterEspecial = false;
    int contador = 0;

    while (contador < password.length() && (!mayuscula || !minuscula || !digito || !caracterEspecial)) {
      char c = password.charAt(contador);
      if(Character.isUpperCase(c))
        mayuscula = true;
      else if(Character.isLowerCase(c))
        minuscula = true;
      else if(Character.isDigit(c))
        digito = true;
      if(c>=33&&c<=46||c==64){
        caracterEspecial = true;
      }
      contador += 1;
    }
    return (mayuscula && minuscula && digito && caracterEspecial);
  }
}
