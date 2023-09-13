package Domain.validador;

import Domain.Personas.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class no_es_insegura extends validacion {
  private Set<String> contrasenias_inseguras = new HashSet<String>();
  private String path = "../2023-tpa-mi-no-grupo-20/src/main/java/Domain/validador/10k-contrasenias.txt";
  private boolean cargadas_contrasenias_inseguras = false;

  public boolean validar(Usuario usuario) {
    String password = usuario.getPassword();
    if(!cargadas_contrasenias_inseguras) {
      this.cargarContraseniasInseguras();
    }
    return !(contrasenias_inseguras.contains(password));
  }

  private void cargarContraseniasInseguras() {
    File file = new File(path);

    try{
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        contrasenias_inseguras.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    cargadas_contrasenias_inseguras = true;
  }
}
