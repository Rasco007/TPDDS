import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidadorDeContrasenia {
  private static final int MIN = 8;
  Set<String> contraseniasInseguras = new HashSet<String>();
  String path = "10k-contrasenias.txt";
  boolean cargadasContraseniasInseguras = false;

  private boolean noEsIgualAlNombre(String nombre, String password){
    return !password.toUpperCase().contains(nombre.toUpperCase());
  }

  private boolean noEsRepeticionesDeCaracteres(String password) {
    char[] stringACaracteres = password.toCharArray();

    for(int i = 0; i < password.length() - 2; i++) {
      if(password.charAt(i) == stringACaracteres[i+1] && stringACaracteres[i+1] == stringACaracteres[i+2]) {
        return false;
      }
    }

    return true;
  }

  private boolean noEstaEnTop10000MasInseguras(String password) {
    return !(contraseniasInseguras.contains(password));
  }

  private void cargarContraseniasInseguras() {
    File file = new File(path);

    try{
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        contraseniasInseguras.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    cargadasContraseniasInseguras = true;
  }

  public void validar(String nombre, String apellido, String password){

    boolean mayuscula = false;
    boolean minuscula = false;
    boolean digito = false;
    boolean caracterEspecial = false;

    if(!cargadasContraseniasInseguras) {
      this.cargarContraseniasInseguras();
    }

    for (int i=0; i < password.length(); i++) {
      char c = password.charAt(i);
      if(Character.isUpperCase(c))
        mayuscula = true;
      else if(Character.isLowerCase(c))
        minuscula = true;
      else if(Character.isDigit(c))
        digito = true;
      if(c>=33&&c<=46||c==64){
        caracterEspecial = true;
      }
    }

    boolean esSegura = this.noEstaEnTop10000MasInseguras(password);
    boolean sinRepeticion = this.noEsRepeticionesDeCaracteres(password);
    boolean diferenteAlNombre = this.noEsIgualAlNombre(nombre, password);
    boolean diferenteAlApellido = this.noEsIgualAlNombre(apellido, password);

    if (password.length() >= MIN && mayuscula && minuscula && digito && caracterEspecial
        && esSegura && sinRepeticion && diferenteAlNombre && diferenteAlApellido) {
      System.out.println("Valid Password");
      return true;
    }
    else {
      System.out.println("Your password does not meet the following requirements:");
      if(password.length() < MIN)
        System.out.println("- At least 8 characters");
      if (!minuscula)
        System.out.println("- At least one lowercase letters");
      if (!mayuscula)
        System.out.println("- At least one uppercase letters");
      if(!digito)
        System.out.println("- At least one numeric digits");
      if(!caracterEspecial)
        System.out.println("- At lest one special characters");
      if (!esSegura)
        System.out.println("- No tiene que pertenecer a 10k-contrasenias");
      if (!sinRepeticion)
        System.out.println("- No tiene que ser repetitiva");
      if(!diferenteAlNombre)
        System.out.println("- Must not contain your name");
      if(!diferenteAlApellido)
        System.out.println("- Must not contain your last name");
      return false;
    }
  }
}
